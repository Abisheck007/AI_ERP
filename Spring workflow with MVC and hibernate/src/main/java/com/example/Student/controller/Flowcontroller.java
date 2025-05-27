package com.example.Student.controller;

import com.example.Student.model.Flow;
import com.example.Student.service.Flowservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5502", "http://127.0.0.1:5502"})

public class Flowcontroller {

    @Autowired
    Flowservice service;
    @PostMapping("/flowadd")
    public String addflow(@RequestBody Flow flow){
        service.addflow(flow);
        return "Flow added successfully";}




    @GetMapping("/showflow")
    public List<Flow> showdata(){
      return service.showdata();
    }

    @DeleteMapping("/deleteallflow")
    public String deleteflow(){
        service.deletedata();
        return "flow data deleted successfulyy";
    }
}


