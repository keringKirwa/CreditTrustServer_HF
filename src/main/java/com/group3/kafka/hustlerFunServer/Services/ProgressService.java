package com.group3.kafka.hustlerFunServer.Services;

import com.group3.kafka.hustlerFunServer.Entities.NewProject;
import com.group3.kafka.hustlerFunServer.Entities.Progress;
import com.group3.kafka.hustlerFunServer.Repositories.ProgressRepository;
import com.group3.kafka.hustlerFunServer.Repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgressService {
    @Autowired
    ProgressRepository progressRepository;
    @Autowired
    ProjectsRepository projectsRepository;
    public Progress save(Progress progress) {

        Progress progressSaved =progressRepository.save(progress);
        Optional<NewProject> optionalNewProject=projectsRepository.findById(progressSaved.getProjectId()) ;
        if(optionalNewProject.isPresent()){
            NewProject project =optionalNewProject.get();
            project.setLatestProgressId(progressSaved.getId());
            return progressSaved;
        }else {
            throw new IllegalStateException("Project for this progress was not found .");
        }
    }

    public Progress getLatestProgress(String latestProgressID) throws Exception {
        Optional<Progress> optionalProgress= progressRepository.findById(latestProgressID);
        if (optionalProgress.isPresent()){
            return optionalProgress.get();
        }
        throw  new Exception("Progress Not found");
    }
}
