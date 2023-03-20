package com.group3.kafka.hustlerFunServer.Services;
import com.group3.kafka.hustlerFunServer.Entities.NewProject;
import com.group3.kafka.hustlerFunServer.Repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsService {
    @Autowired
    private ProjectsRepository  projectsRepository;

    public NewProject createNewProject(NewProject myProject) {
        return projectsRepository.save(myProject);
    }

    public NewProject findOneByFarmerID(String farmerID) {
        return projectsRepository.findOneByFarmerId(farmerID);

    }
    public List<NewProject> findAllByFarmerID(String farmerID) {
        return projectsRepository.findAllByFarmerId(farmerID);

    }

    public List<NewProject> retrieveAllProjects() {
        return projectsRepository.findAll();

    }
}

