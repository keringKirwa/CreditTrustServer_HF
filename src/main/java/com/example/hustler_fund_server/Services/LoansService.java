package com.example.hustler_fund_server.Services;

import com.example.hustler_fund_server.Repositories.LoansRepository;
import com.example.hustler_fund_server.Repositories.NotificationsRepository;
import com.example.hustler_fund_server.Repositories.ProjectsRepository;
import com.example.hustler_fund_server.Repositories.RegisterFarmerRepository;
import com.example.hustler_fund_server.Entities.Farmer;
import com.example.hustler_fund_server.Entities.Loan;
import com.example.hustler_fund_server.Entities.NewProject;
import com.example.hustler_fund_server.Entities.Notification;
import com.example.hustler_fund_server.utils.NextDisbursementDateGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoansService {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Loan> getAllLoanDocuments() {
        List<Loan> loans = mongoTemplate.findAll(Loan.class, "loansCollection");
        return loans;
    }

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private RegisterFarmerRepository farmerRepository;

    @Autowired
    private NextDisbursementDateGenerator nextDisbursementDateGenerator;
    @Autowired
    private ProjectsRepository projectsRepository;
    @Autowired
    private NotificationsRepository notificationsRepository;

    public Loan save(Loan loan) throws Exception {
        Optional<Farmer> farmerOptional = farmerRepository.findById(loan.getFarmerId());
        if (farmerOptional.isPresent()) {
            Farmer farmer = farmerOptional.get();
            if (farmer.getActiveLoanId() != null) {
                throw new IllegalStateException("You have an active loan. Please wait until  this loan is settled.");

            }
            Loan savedLoan = loansRepository.save(loan);

            farmer.setHasActiveLoan(true);
            farmer.setActiveLoanId(savedLoan.getId());
            farmerRepository.save(farmer);
            return savedLoan;

        } else {
            throw new IllegalStateException("The farmer with this id  was not found .");
        }

    }

    public List<Loan> findAllByFarmerId(String farmerID) {
        return loansRepository.findAllByFarmerId(farmerID);

    }

    public Loan findLoanByID(String activeLoanID) throws Exception {

        Optional<Loan> optionalLoan = loansRepository.findById(activeLoanID);
        if (optionalLoan.isPresent()) {
            return optionalLoan.get();
        } else {
            throw new Exception("Loan with that ID was not found.");
        }
    }

    public Loan completeLoanDisbursement(String activeLoanID) throws Exception {

        Optional<Loan> optionalLoan = loansRepository.findById(activeLoanID);
        if (optionalLoan.isPresent()) {

            Loan loan = optionalLoan.get();

            loan.setAmountDisbursed(loan.getAmountBorrowed());

            loan.setDisbursementStatus((byte) 2);
            return loansRepository.save(loan);

        } else {
            throw new Exception("Loan with that ID was not found.");
        }
    }

    public Loan findLoanByIDAndUpdateApprovalStatus(String activeLoanID, byte approvalStatus) throws Exception {

        Optional<Loan> optionalLoan = loansRepository.findById(activeLoanID);

        if (optionalLoan.isPresent()) {
            Loan loan = optionalLoan.get();

            Optional<NewProject> optionalNewProject = projectsRepository.findById(loan.getProjectId());

            if (optionalNewProject.isPresent()) {

                NewProject newProject = optionalNewProject.get();

                Farmer farmer = farmerRepository.findById(newProject.getFarmerId()).get();

                loan.setApprovalStatus(approvalStatus);
                Notification notification=new Notification();
                notification.setFarmerId(farmer.getId());
                notification.setMessage("Hello Mr "+ farmer.getName() + ", Your loan "+ "of Ksh "+loan.getAmountBorrowed()+" for the project "+newProject.getProjectName()+" Has been approved.Please Check you account for the same .");
                notificationsRepository.save(notification);

                Notification loanDisbursementNotification=new Notification();
                loanDisbursementNotification.setFarmerId(farmer.getId());

                loanDisbursementNotification.setMessage("Hello Mr "+ farmer.getName() + " ,The first batch of Your loan "+ "of Ksh "+loan.getAmountBorrowed()+" for the project "+newProject.getProjectName()+" Has been Disbursed.Please Check you account within 24  hours .");
                notificationsRepository.save(loanDisbursementNotification);

                loan.setAmountDisbursed(loan.getAmountBorrowed() / 2);
                loan.setDisbursementStatus((byte) 1);
                loan.setNextBatchOn(nextDisbursementDateGenerator.getNextLoanBatchDate(newProject.getNumberOfMonths()));
                return loansRepository.save(loan);

            } else {
                throw new Exception("Project for this Loan was not found.");
            }

        } else {
            throw new Exception("Loan with that ID was not found.");
        }
    }
}