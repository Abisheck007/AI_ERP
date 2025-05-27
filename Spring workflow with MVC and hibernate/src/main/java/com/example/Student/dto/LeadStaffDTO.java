package com.example.Student.dto;
public class LeadStaffDTO {
    private String name;
    private String email;
    private String enrolledCourse;
    private String phone;
    private String staffName;

    public LeadStaffDTO(String name,String phone, String email, String enrolledCourse, String staffName) {
        this.name = name;
        this.email = email;
        this.enrolledCourse = enrolledCourse;
        this.phone = phone;
        this.staffName = staffName;
    }

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getEnrolledCourse() {
        return enrolledCourse;
    }

    public void setEnrolledCourse(String enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
