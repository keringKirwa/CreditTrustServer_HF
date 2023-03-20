package com.group3.kafka.hustlerFunServer.Services;
import com.group3.kafka.hustlerFunServer.Entities.MyProject;
import com.group3.kafka.hustlerFunServer.Repositories.CreateProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateProjectService {
    @Autowired
    private CreateProjectRepository createProjectRepository;


    public MyProject create(MyProject myProject) {
        return createProjectRepository.save(myProject);
    }
}

