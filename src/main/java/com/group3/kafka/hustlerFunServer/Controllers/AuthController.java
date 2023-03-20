package com.group3.kafka.hustlerFunServer.Controllers;

import com.group3.kafka.hustlerFunServer.Entities.Farmer;
import com.group3.kafka.hustlerFunServer.Services.RegisterFarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController{
    @Autowired
    RegisterFarmerService registerFarmerService;

    @PostMapping("/register")
    public  Farmer registerUser(@RequestBody Farmer farmer) {
        return registerFarmerService.register(farmer);
    }
    @GetMapping("/getAllFarmers")
    public List<Farmer> getAllFarmers() {
       return registerFarmerService.findAll();
    }

    @GetMapping("/findFarmerById/{id}")
    public Farmer findById(@PathVariable String id) throws Exception {
        return registerFarmerService.findByFarmerID(id);

    }




}
