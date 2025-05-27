package com.example.Student.controller;


import com.example.Student.dto.LeadStaffDTO;
import com.example.Student.dto.Leaddto;
import com.example.Student.dto.StaffStudentCountDTO;
import com.example.Student.model.Lead;
import com.example.Student.model.Staff;
import com.example.Student.repository.LeadRepository;
import com.example.Student.service.LeadService;
import com.example.Student.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:5502", "http://127.0.0.1:5502"})
@RestController

public class LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping("/with-staffname")
    public List<LeadStaffDTO> getLeadsWithStaff(@RequestParam String staffName) {
        return leadService.getLeadsByStaffName(staffName);
    }


    @GetMapping("/with-staffs")
    public List<Leaddto> getLeadsWithStaff() {
        return leadService.getLeadWithStaffInfo();
    }


    @GetMapping("/staff/student-count")
    public List<StaffStudentCountDTO> getStudentCountPerStaff() {
        return leadService.getStudentCountPerStaff();
    }

    @GetMapping("/staff/{staffName}/student-count")
    public Long getStudentCountByStaff(@PathVariable String staffName) {
        return leadService.countStudentsByStaffName(staffName);
    }

    @GetMapping("/admin/total-students")
    public Long getTotalAssignedStudentCount() {
        return leadService.getTotalAssignedStudentCount();
    }



    @GetMapping("/leads/by-course")
    public ResponseEntity<List<Lead>> getLeadsByEnrolledCourse(@RequestParam String enrolledCourse) {
        List<Lead> leads = leadService.getLeadsByEnrolledCourse(enrolledCourse);
        return new ResponseEntity<>(leads, HttpStatus.OK);
    }



    @PostMapping("/getdata")
    public Lead createLead(@RequestBody Lead lead) {
        return leadService.saveLead(lead);
    }

    @GetMapping("/showdata")
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }




    @DeleteMapping("/deleteall")
    public String deletedata(){
        leadService.deletedata();
        return "deleted successfully";

    }


    @PutMapping("/updatelead/{id}")
    public ResponseEntity<String> updateLeadById(@PathVariable Long id, @RequestBody Lead updatedLead) {
        boolean updated = leadService.updateLeadById(id, updatedLead);
        if (updated) {
            return ResponseEntity.ok("✅ Lead fully updated!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("❌ Lead not found.");
        }
    }


    @PutMapping("/updateleadbyname/{name}")
    public ResponseEntity<String> updateLeadByName(@PathVariable String name, @RequestBody Lead updatedLead) {
        boolean updated = leadService.updateLeadByName(name, updatedLead);
        if (updated) {
            return ResponseEntity.ok("✅ Lead updated by name!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("❌ Lead with given name not found.");
        }
    }
//staff

    @Autowired
    private StaffService staffService;



    @PostMapping("/poststaff")
    public void submitStaff(@RequestBody Staff staff) {
        staffService.saveStaff(staff);

    }

    @GetMapping("/getstaff")
    public List<Staff> getalldata(){
        return staffService.getalldata();
    }

    @DeleteMapping("/deletestaff")
    public void deleteall(){
        staffService.deletestaff();
    }
}
