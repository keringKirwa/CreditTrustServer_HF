package com.group3.kafka.hustlerFunServer.Services;
import com.group3.kafka.hustlerFunServer.Entities.Message;
import com.group3.kafka.hustlerFunServer.Repositories.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesService {
    @Autowired
    private MessagesRepository messagesRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Message save(Message message) {
        System.out.println(message.getUserId());
        return messagesRepository.save(message);
    }

    public List<Message> getAllMessages() {
        List<Message> messages = mongoTemplate.findAll(Message.class, "messagesCollection");

        return messages;
    }

}

