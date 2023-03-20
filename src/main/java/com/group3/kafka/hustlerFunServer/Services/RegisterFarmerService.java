package com.group3.kafka.hustlerFunServer.Services;

import com.group3.kafka.hustlerFunServer.Entities.Farmer;
import com.group3.kafka.hustlerFunServer.Repositories.RegisterFarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RegisterFarmerService {

    @Autowired
    private RegisterFarmerRepository registerFarmerRepository;
    public Farmer register(Farmer farmer) {
       return  registerFarmerRepository.save(farmer);
    }

    public List<Farmer> findAll() {
        return registerFarmerRepository.findAll();
    }

    public Farmer findByFarmerID(String id) throws Exception {

      Optional<Farmer> farmerOptional=registerFarmerRepository.findById(id);
      if(farmerOptional.isPresent()){
          return farmerOptional.get();
      }
      throw  new Exception("Farmer with that id was not found");
    }
}
