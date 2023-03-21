package com.group3.kafka.hustlerFunServer.Services;

import com.group3.kafka.hustlerFunServer.Entities.Loan;
import com.group3.kafka.hustlerFunServer.Entities.NewProject;
import com.group3.kafka.hustlerFunServer.Repositories.LoansRepository;
import com.group3.kafka.hustlerFunServer.Repositories.ProjectsRepository;
import com.group3.kafka.hustlerFunServer.utils.NextDisbursementDateGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  LoansService {
    @Autowired
    private LoansRepository loansRepository;
    @Autowired
    private NextDisbursementDateGenerator nextDisbursementDateGenerator;
    @Autowired
    private ProjectsRepository projectsRepository;



    public Loan save(Loan loan) {

        return loansRepository.save(loan);
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
            Loan loan=optionalLoan.get();

            Optional<NewProject> optionalNewProject = projectsRepository.findById(loan.getProjectId());

            if (optionalNewProject.isPresent()) {

                NewProject newProject =optionalNewProject.get();

                loan.setApprovalStatus(approvalStatus);
                loan.setAmountDisbursed(loan.getAmountBorrowed() / 2);
                loan.setDisbursementStatus((byte) 1);
                loan.setNextBatchOn(nextDisbursementDateGenerator.getNextLoanBatchDate(newProject.getNumberOfMonths()));
                return loansRepository.save(loan);

            }else {
                throw new Exception("Project for this Loan was not found.");
            }


        } else {
            throw new Exception("Loan with that ID was not found.");
        }
    }
}