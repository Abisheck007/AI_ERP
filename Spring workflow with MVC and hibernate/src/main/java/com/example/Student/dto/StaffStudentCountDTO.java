package com.example.Student.dto;



public class StaffStudentCountDTO {
    private String staffName;
    private Long studentCount;

    public StaffStudentCountDTO(String staffName, Long studentCount) {
        this.staffName = staffName;
        this.studentCount = studentCount;
    }

    public String getStaffName() {
        return staffName;
    }

    public Long getStudentCount() {
        return studentCount;
    }
}
