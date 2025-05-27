package com.example.Student.service;


import com.example.Student.dto.LeadStaffDTO;
import com.example.Student.dto.Leaddto;
import com.example.Student.dto.StaffStudentCountDTO;
import com.example.Student.model.Flow;
import com.example.Student.model.Lead;
import com.example.Student.repository.Flowrepo;
import com.example.Student.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService {

    @Autowired
    private LeadRepository repo;

    @Autowired
    Flowrepo flowRepo;

    public Lead saveLead(Lead lead) {


        return repo.save(lead);
    }


    public List<Lead> getAllLeads() {
        return repo.findAll();
    }

    public void deletedata() {
        repo.deleteAll();
    }

    public boolean updateLeadById(Long id, Lead updatedLead) {
        Optional<Lead> optionalLead = repo.findById(id);
        if (optionalLead.isPresent()) {
            Lead existingLead = optionalLead.get();

            existingLead.setStatus(updatedLead.getStatus());
            existingLead.setSource(updatedLead.getSource());
            existingLead.setName(updatedLead.getName());
            existingLead.setAddress(updatedLead.getAddress());
            existingLead.setPosition(updatedLead.getPosition());
            existingLead.setCity(updatedLead.getCity());
            existingLead.setEmail(updatedLead.getEmail());
            existingLead.setState(updatedLead.getState());
            existingLead.setWebsite(updatedLead.getWebsite());
            existingLead.setCountry(updatedLead.getCountry());
            existingLead.setPhone(updatedLead.getPhone());
            existingLead.setZipcode(updatedLead.getZipcode());
            existingLead.setEnrolledCourse(updatedLead.getEnrolledCourse());
            existingLead.setSecondaryAddress(updatedLead.getSecondaryAddress());
            existingLead.setDescription(updatedLead.getDescription());



           repo.save(existingLead);
            return true;
        }
        return false;
    }

    public boolean updateLeadByName(String name, Lead updatedLead) {
        Optional<Lead> optionalLead = repo.findByName(name);
        if (optionalLead.isPresent()) {
            Lead existingLead = optionalLead.get();

            existingLead.setStatus(updatedLead.getStatus());
            existingLead.setSource(updatedLead.getSource());
            existingLead.setName(updatedLead.getName());
            existingLead.setAddress(updatedLead.getAddress());
            existingLead.setPosition(updatedLead.getPosition());
            existingLead.setCity(updatedLead.getCity());
            existingLead.setEmail(updatedLead.getEmail());
            existingLead.setState(updatedLead.getState());
            existingLead.setWebsite(updatedLead.getWebsite());
            existingLead.setCountry(updatedLead.getCountry());
            existingLead.setPhone(updatedLead.getPhone());
            existingLead.setZipcode(updatedLead.getZipcode());
            existingLead.setEnrolledCourse(updatedLead.getEnrolledCourse());
            existingLead.setSecondaryAddress(updatedLead.getSecondaryAddress());
            existingLead.setDescription(updatedLead.getDescription());


           repo.save(existingLead);
            return true;
        }
        return false;
    }



    public void alldata(Long id) {
        repo.findById(id);
    }
    public List<Lead> getLeadsByEnrolledCourse(String enrolledCourse) {
        return repo.findByEnrolledCourse(enrolledCourse);
    }



    public List<LeadStaffDTO> getLeadsByStaffName(String staffName) {
        return repo.findLeadsByStaffName(staffName);
    }

    public List<Leaddto> getLeadWithStaffInfo() {
        return repo.fetchLeadWithStaffs();
    }

    public List<StaffStudentCountDTO> getStudentCountPerStaff() {
        return repo.getStudentCountPerStaff();
    }
    public Long countStudentsByStaffName(String staffName) {
        return repo.countStudentsByStaffName(staffName);
    }

    public Long getTotalAssignedStudentCount() {
        return repo.getTotalAssignedStudentCount();
    }


}
