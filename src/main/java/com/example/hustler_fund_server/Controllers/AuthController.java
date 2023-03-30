package com.example.hustler_fund_server.Controllers;

import com.example.hustler_fund_server.Entities.Farmer;
import com.example.hustler_fund_server.Entities.LoginDetails;
import com.example.hustler_fund_server.Services.RegisterFarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {
    @Autowired
    RegisterFarmerService registerFarmerService;

    @PostMapping("/register")
    public Farmer registerUser(@RequestBody Farmer farmer) {
        return registerFarmerService.register(farmer);
    }

    @PostMapping("/login")
    public Farmer login(@RequestBody LoginDetails loginDetails) throws Exception {

        return registerFarmerService.login(loginDetails);
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
