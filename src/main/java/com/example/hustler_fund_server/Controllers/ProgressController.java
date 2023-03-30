package com.example.hustler_fund_server.Controllers;

import com.example.hustler_fund_server.Services.ProgressService;
import com.example.hustler_fund_server.Entities.Progress;
import com.example.hustler_fund_server.Producers.ProgressProducer;
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
