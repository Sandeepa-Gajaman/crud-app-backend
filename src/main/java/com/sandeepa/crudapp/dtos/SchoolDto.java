package com.sandeepa.crudapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolDto {

    private String schoolName;
    private String schoolAddress;
    private List<StudentDto> students;

    /*

    @NoArgsConstructor creates this constructor.
    School service getSchoolDetails() use this constructor
    public SchoolDto() {
    }

    @AllArgsConstructor creates this constructor
    School service getSchoolById() use this constructor
    public SchoolDto(String schoolName, String schoolAddress, List<StudentDto> students) {
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;
        this.students = students;
    }

    @Data is a shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, @Setter on all non-final fields,
    and @RequiredArgsConstructor!
    Refer: https://projectlombok.org/features/Data

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

     */
}
