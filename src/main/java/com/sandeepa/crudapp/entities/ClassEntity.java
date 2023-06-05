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

    @OneToOne(mappedBy = "aClass")
    private TeacherEntity teacher;

}
