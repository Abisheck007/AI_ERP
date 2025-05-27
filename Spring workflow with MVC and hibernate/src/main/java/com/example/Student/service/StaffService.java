package com.example.Student.service;
import com.example.Student.model.Staff;
import com.example.Student.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public void saveStaff(Staff staff) {
        staffRepository.save(staff);
    }


    public List<Staff> getalldata() {
         return staffRepository.findAll();
    }

    public void deletestaff() {
        staffRepository.deleteAll();
    }
}

