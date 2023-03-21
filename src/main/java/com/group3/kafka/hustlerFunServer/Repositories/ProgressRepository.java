package com.group3.kafka.hustlerFunServer.Repositories;

import com.group3.kafka.hustlerFunServer.Entities.Progress;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgressRepository extends MongoRepository<Progress, String> {
    List<Progress> findAll();

    List<Progress> findAllByProjectId(String projectID);

    Optional<Progress> findById(String activeLoanID);


}