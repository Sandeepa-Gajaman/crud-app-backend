package com.sandeepa.crudapp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "school")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class SchoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NonNull private String name;
    @NonNull private String address;

    @OneToMany(mappedBy = "studentSchool", cascade = CascadeType.ALL)
    List<StudentEntity> students = new ArrayList<>();

    @OneToMany(mappedBy = "teacherSchool", cascade = CascadeType.ALL)
    List<TeacherEntity> teachers = new ArrayList<>();

    /*
    To create the below constructor use the @RequiredArgsConstructor annotation with the @NonNull annotation
    on the fields you want to include in the constructor.

    public SchoolEntity(String name, String address) {
        this.name = name;
        this.address = address;
    }

     */
}
