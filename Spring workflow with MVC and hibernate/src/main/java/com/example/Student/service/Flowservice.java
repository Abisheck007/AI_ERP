package com.example.Student.service;

import com.example.Student.model.Flow;
import com.example.Student.repository.Flowrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Flowservice {
    @Autowired
    Flowrepo repo;

    public void addflow(Flow flow) {

        repo.save(flow);
    }

    public List<Flow> showdata() {
        return  repo.findAll();

    }

    public void deletedata() {
        repo.deleteAll();
    }
}
