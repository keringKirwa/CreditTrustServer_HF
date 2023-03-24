package com.group3.kafka.hustlerFunServer.Services;

import com.group3.kafka.hustlerFunServer.Entities.Farmer;
import com.group3.kafka.hustlerFunServer.Entities.LoginDetails;
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
        Optional<Farmer> optionalFarmer = Optional.ofNullable(registerFarmerRepository.findByEmail(farmer.getEmail()));
        if (optionalFarmer.isPresent()){
            throw  new IllegalStateException("A farmer with that emailAddress Already Exists.");
        }

        return registerFarmerRepository.save(farmer);
    }

    public List<Farmer> findAll() {
        return registerFarmerRepository.findAll();
    }

    public Farmer findByFarmerID(String id) throws Exception {

        Optional<Farmer> farmerOptional = registerFarmerRepository.findById(id);
        if (farmerOptional.isPresent()) {
            return farmerOptional.get();
        }
        throw new Exception("Farmer with that id was not found");
    }

    public Farmer login(LoginDetails loginDetails) throws Exception {
        Farmer farmer = registerFarmerRepository.findByEmail(loginDetails.getEmail());
        System.out.println("this is the farmer email address: " + loginDetails.getEmail());
        if (farmer.getEmail().equals(loginDetails.getEmail())) {
            return farmer;
        }
        throw new Exception("farmer with that email address was not found ");
    }
}
