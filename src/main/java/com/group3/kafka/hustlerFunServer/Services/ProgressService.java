package com.group3.kafka.hustlerFunServer.Services;

import com.group3.kafka.hustlerFunServer.Entities.Progress;
import com.group3.kafka.hustlerFunServer.Repositories.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgressService {
    @Autowired
    ProgressRepository progressRepository;
    public Progress save(Progress progress) {
        return progressRepository.save(progress);
    }

    public Progress getLatestProgress(String latestProgressID) throws Exception {
        Optional<Progress> optionalProgress= progressRepository.findById(latestProgressID);
        if (optionalProgress.isPresent()){
            return optionalProgress.get();
        }
        throw  new Exception("Progress Not found");
    }
}
