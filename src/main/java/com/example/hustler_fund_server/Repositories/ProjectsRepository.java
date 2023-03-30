package com.example.hustler_fund_server.Repositories;

import com.example.hustler_fund_server.Entities.NewProject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectsRepository extends MongoRepository<NewProject, String> {
    List<NewProject> findAll();
    List<NewProject> findAllByFarmerId(String farmerId);

    NewProject findOneByFarmerId(String farmerId);



}
