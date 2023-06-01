package com.sandeepa.crudapp.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "school")
public class SchoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_fk", referencedColumnName = "id")
    List<StudentEntity> schoolName = new ArrayList<>();

    public List<StudentEntity> getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(List<StudentEntity> studentDTO) {
        this.schoolName = studentDTO;
    }

    public SchoolEntity() {
    }

    public SchoolEntity(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SchoolDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
