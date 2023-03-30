package com.example.hustler_fund_server.Repositories;

import com.example.hustler_fund_server.Entities.Notification;
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