package com.group3.kafka.hustlerFunServer.Repositories;

import com.group3.kafka.hustlerFunServer.Entities.Farmer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RegisterFarmerRepository extends MongoRepository<Farmer, String> {
    List<Farmer> findAll();
}
