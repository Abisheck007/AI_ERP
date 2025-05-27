package com.example.Student.repository;


import com.example.Student.dto.LeadStaffDTO;
import com.example.Student.dto.Leaddto;
import com.example.Student.dto.StaffStudentCountDTO;
import com.example.Student.model.Lead;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

    List<Lead> findByEnrolledCourse(String enrolledCourse);

    Optional<Lead> findByName(String name);

    @Query("SELECT new com.example.Student.dto.LeadStaffDTO(l.name, l.email,l.phone, l.enrolledCourse, s.staffName) " +
            "FROM Lead l JOIN Staff s ON l.enrolledCourse = s.course " +
            "WHERE s.staffName = :staffName")
    List<LeadStaffDTO> findLeadsByStaffName(@Param("staffName") String staffName);

    @Query("SELECT new com.example.Student.dto.Leaddto(l.id, l.name, l.email, l.phone, l.enrolledCourse, s.staffName) " +
            "FROM Lead l JOIN Staff s ON l.enrolledCourse = s.course")
    List<Leaddto> fetchLeadWithStaffs();

    @Query("SELECT new com.example.Student.dto.StaffStudentCountDTO(s.staffName, COUNT(l)) " +
            "FROM Lead l JOIN Staff s ON l.enrolledCourse = s.course " +
            "GROUP BY s.staffName")
    List<StaffStudentCountDTO> getStudentCountPerStaff();


    @Query("SELECT COUNT(l) FROM Lead l JOIN Staff s ON l.enrolledCourse = s.course WHERE s.staffName = :staffName")
    Long countStudentsByStaffName(@Param("staffName") String staffName);

    @Query("SELECT COUNT(l) FROM Lead l JOIN Staff s ON l.enrolledCourse = s.course")
    Long getTotalAssignedStudentCount();


}
