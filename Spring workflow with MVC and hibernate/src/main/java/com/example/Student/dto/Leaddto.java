package com.example.Student.dto;

public class Leaddto {
    private Long leadId;
    private String leadName;
    private String email;
    private String phone;
    private String enrolledCourse;
    private String staffName;


    public Leaddto(Long leadId, String leadName, String email, String phone, String enrolledCourse, String staffName) {
        this.leadId = leadId;
        this.leadName = leadName;
        this.email = email;
        this.phone = phone;
        this.enrolledCourse = enrolledCourse;
        this.staffName = staffName;
    }


    public Long getLeadId() { return leadId; }
    public void setLeadId(Long leadId) { this.leadId = leadId; }

    public String getLeadName() { return leadName; }
    public void setLeadName(String leadName) { this.leadName = leadName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEnrolledCourse() { return enrolledCourse; }
    public void setEnrolledCourse(String enrolledCourse) { this.enrolledCourse = enrolledCourse; }

    public String getStaffName() { return staffName; }
    public void setStaffName(String staffName) { this.staffName = staffName; }
}


