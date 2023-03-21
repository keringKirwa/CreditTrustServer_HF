package com.group3.kafka.hustlerFunServer.Services;

import com.group3.kafka.hustlerFunServer.Entities.Loan;
import com.group3.kafka.hustlerFunServer.Repositories.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  LoansService {
    @Autowired
    private LoansRepository loansRepository;


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

    public Loan findLoanByIDAndUpdateAmountDisbursed(String activeLoanID, int amountDisbursed) throws Exception {

        Optional<Loan> optionalLoan = loansRepository.findById(activeLoanID);
        if (optionalLoan.isPresent()) {

            Loan loan = optionalLoan.get();
            loan.setAmountDisbursed(amountDisbursed);

            if(amountDisbursed == loan.getAmountBorrowed()){
                loan.setDisbursementStatus((byte) 2);
            }
            if (amountDisbursed > 0 && amountDisbursed < loan.getAmountDisbursed()){
                loan.setDisbursementStatus((byte) 1);
            }
            return loansRepository.save(loan);

        } else {
            throw new Exception("Loan with that ID was not found.");
        }


    }
    public Loan findLoanByIDAndUpdateApprovalStatus(String activeLoanID, byte approvalStatus) throws Exception {

        Optional<Loan> optionalLoan = loansRepository.findById(activeLoanID);
        if (optionalLoan.isPresent()) {

            Loan loan = optionalLoan.get();
            loan.setApprovalStatus((byte) 1);
            return loansRepository.save(loan);

        } else {
            throw new Exception("Loan with that ID was not found.");
        }
    }




}