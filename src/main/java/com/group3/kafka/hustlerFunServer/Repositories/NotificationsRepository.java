package com.group3.kafka.hustlerFunServer.Repositories;

import com.group3.kafka.hustlerFunServer.Entities.Notification;
import com.group3.kafka.hustlerFunServer.Entities.Progress;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationsRepository extends MongoRepository<Notification, String> {
    List<Notification> findAll();

    List<Notification> findAllByFarmerId(String projectID);

    Optional<Notification> findById(String activeLoanID);


}