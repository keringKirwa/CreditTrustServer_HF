package com.group3.kafka.hustlerFunServer.Controllers;

import com.group3.kafka.hustlerFunServer.Entities.Progress;
import com.group3.kafka.hustlerFunServer.Producers.ProgressProducer;
import com.group3.kafka.hustlerFunServer.Services.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProgressController{
    @Autowired
    ProgressService progressService;
    @Autowired
    ProgressProducer progressProducer;

    @PostMapping("/createProgress")
    public String createProgress(@RequestBody Progress progress) {
        progressProducer.publishProgressEvent(progress);
        return "success";
    }
    @GetMapping("/getLatestProgress/{latestProgressID}")
    public Progress getLatestProgressByID(@PathVariable String latestProgressID) throws Exception {
        return progressService.getLatestProgress(latestProgressID);

    }




}
