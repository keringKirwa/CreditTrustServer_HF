package com.group3.kafka.hustlerFunServer.Controllers;

import com.group3.kafka.hustlerFunServer.Entities.Message;
import com.group3.kafka.hustlerFunServer.Producers.FirstProducer;
import com.group3.kafka.hustlerFunServer.Producers.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Autowired
    private final FirstProducer producer;

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    public TestController(FirstProducer producer) {
        this.producer = producer;
    }
    @PostMapping("/publishTestMessage")
    public void messageToTopic(@RequestParam("message") Message message){

        this.producer.sendMessage(message);


    }
    @PostMapping("/publishMessage")
    public void publishMessage(@RequestBody Message message){

        this.messageProducer.sendMessage(message);


    }
}
