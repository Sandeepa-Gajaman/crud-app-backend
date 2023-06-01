package com.sandeepa.crudapp.dto;

import java.util.List;

public class SchoolDto {

    private String schoolName;
    private String schoolAddress;
    private List<StudentDto> students;

    public SchoolDto() {
    }

    public SchoolDto(String schoolName, String schoolAddress, List<StudentDto> students) {
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;
        this.students = students;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }
}
