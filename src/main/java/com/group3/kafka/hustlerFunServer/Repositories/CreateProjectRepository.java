package com.group3.kafka.hustlerFunServer.Repositories;

import com.group3.kafka.hustlerFunServer.Entities.MyProject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CreateProjectRepository extends MongoRepository<MyProject, String> {
    List<MyProject> findAll();


}
