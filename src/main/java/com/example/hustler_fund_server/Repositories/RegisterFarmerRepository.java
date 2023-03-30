package com.example.hustler_fund_server.Repositories;

import com.example.hustler_fund_server.Entities.Farmer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RegisterFarmerRepository extends MongoRepository<Farmer, String> {
    List<Farmer> findAll();
     Farmer findByEmail(String emailAddress);
}
