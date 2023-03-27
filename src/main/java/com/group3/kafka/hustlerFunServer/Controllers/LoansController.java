package com.group3.kafka.hustlerFunServer.Controllers;

import com.group3.kafka.hustlerFunServer.Entities.Loan;
import com.group3.kafka.hustlerFunServer.Services.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    LoansService loansService;

    @PostMapping("/createLoan")
    public Loan saveLoan(@RequestBody Loan newLoan) throws Exception {
        return loansService.save(newLoan);
    }

    @GetMapping("/getAllLoans")
    public List<Loan> getAllLoans() {
        return loansService.getAllLoanDocuments();
    }

    @GetMapping("/getActiveLoan/{activeLoanID}")
    public Loan findLoanByID(@PathVariable String activeLoanID) throws Exception {
        return loansService.findLoanByID(activeLoanID);

    }

    @GetMapping("/getAllLoans/{farmerID}")
    public List<Loan> findAllByFarmerID(@PathVariable String farmerID) {
        return loansService.findAllByFarmerId(farmerID);

    }

    @GetMapping("/findLoanByIDAndCompleteLoanDisbursement/{loanID}")
    public Loan completeLoanDisbursement(@PathVariable String loanID) throws Exception {
        return loansService.completeLoanDisbursement(loanID);

    }

    @GetMapping("/findLoanByIDAndUpdateApprovalStatus/{loanID}")
    public Loan findLoanByIDAndUpdateApprovalStatus(@PathVariable String loanID) throws Exception {
        return loansService.findLoanByIDAndUpdateApprovalStatus(loanID, (byte) 1);

    }

}
