package com.sandeepa.crudapp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "class")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull private String name;

    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private TeacherEntity teacher;

    @OneToMany(mappedBy = "aClass", cascade = CascadeType.ALL)
    private List<StudentEntity> students;
}
