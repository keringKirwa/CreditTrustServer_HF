package com.group3.kafka.hustlerFunServer.Repositories;

import com.group3.kafka.hustlerFunServer.Entities.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoansRepository extends MongoRepository<Loan, String> {
    List<Loan> findAll();

    List<Loan> findAllByFarmerId(String farmerID);

    Optional<Loan> findById(String activeLoanID);


}
