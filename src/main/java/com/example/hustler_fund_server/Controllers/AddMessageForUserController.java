package com.example.hustler_fund_server.Controllers;

import com.example.hustler_fund_server.Repositories.MessagesRepository;
import com.example.hustler_fund_server.Services.MessagesService;
import com.example.hustler_fund_server.Entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddMessageForUserController {

    @Autowired
    private MessagesService service;
    @Autowired
    MessagesRepository messagesRepository;

    @PostMapping(value = "/postMessage")
    public Message post(@RequestBody Message data) {
        System.out.println("====++++++++++++++++++++++++>>>>>>> POST request for the ADDING NEW messages ....");
        System.out.println(data.getStringMessage());
        return service.save(data);
    }
    @GetMapping(value = "/getMessages")
    public List<Message> getAllMessages() {
        System.out.println("====++++++++++++++++++++++++>>>>>>> Get request for the get messages ....");

        return  messagesRepository.findAll();

    }

}