package com.group3.kafka.hustlerFunServer.Controllers;

import com.group3.kafka.hustlerFunServer.Entities.MyProject;
import com.group3.kafka.hustlerFunServer.Services.CreateProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectsController{
    @Autowired
    CreateProjectService createProjectService;

    @PostMapping("/createProject")
    public MyProject registerUser(@RequestBody MyProject myProject) {
        return createProjectService.create(myProject);



    }



}