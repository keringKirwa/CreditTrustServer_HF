package com.example.hustler_fund_server.Repositories;

import com.example.hustler_fund_server.Entities.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessagesRepository extends MongoRepository<Message, String> {
    List<Message> findAll();


}
