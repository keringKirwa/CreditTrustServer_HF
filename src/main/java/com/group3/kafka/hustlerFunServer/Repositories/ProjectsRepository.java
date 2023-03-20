package com.group3.kafka.hustlerFunServer.Repositories;

import com.group3.kafka.hustlerFunServer.Entities.NewProject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectsRepository extends MongoRepository<NewProject, String> {
    List<NewProject> findAll();
    List<NewProject> findAllByFarmerId(String farmerId);

    NewProject findOneByFarmerId(String farmerId);



}
