package com.group3.kafka.hustlerFunServer.Controllers;

import com.group3.kafka.hustlerFunServer.Entities.NewProject;
import com.group3.kafka.hustlerFunServer.Services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectsController {
    @Autowired
    ProjectsService projectsService;

    @PostMapping("/createProject")
    public NewProject createNewProject(@RequestBody NewProject newProject) {
        return projectsService.createNewProject(newProject);
    }

    @GetMapping("/getAllFarmersProjects/{farmerID}")
    public List<NewProject> findAllByFarmerID(@PathVariable String farmerID) {
        return projectsService.findAllByFarmerID(farmerID);

    }

    @GetMapping("/getOneFarmersProject/{farmerId}")
    public List<NewProject> retrieveAllProjects() {
        return projectsService.retrieveAllProjects();

    }

}