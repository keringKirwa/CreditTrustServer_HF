package com.group3.kafka.hustlerFunServer.Repositories;

import com.group3.kafka.hustlerFunServer.Entities.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessagesRepository extends MongoRepository<Message, String> {
    List<Message> findAll();


}
