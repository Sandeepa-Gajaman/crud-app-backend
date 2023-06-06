package com.sandeepa.crudapp.config;

import com.sandeepa.crudapp.entities.ClassEntity;
import com.sandeepa.crudapp.entities.SchoolEntity;
import com.sandeepa.crudapp.entities.StudentEntity;
import com.sandeepa.crudapp.entities.TeacherEntity;
import com.sandeepa.crudapp.repositories.ClassRepository;
import com.sandeepa.crudapp.repositories.SchoolRepository;
import com.sandeepa.crudapp.repositories.StudentRepository;
import com.sandeepa.crudapp.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
@AllArgsConstructor
public class DataConfig {

//    private final SchoolRepository schoolRepository;
//    private final TeacherRepository teacherRepository;
//    private final ClassRepository classRepository;
//    private final StudentRepository studentRepository;
//
//    @Bean
//    CommandLineRunner commandLineRunner(){
//        return args -> {
//
//            //Class
//            ClassEntity mythology = new ClassEntity(
//                    "Mythology"
//            );
//            ClassEntity darkArtsDefense = new ClassEntity(
//                    "Dark Arts Defense"
//            );
//            ClassEntity cryptology = new ClassEntity(
//                    "Cryptology"
//            );
//            ClassEntity advancedAlchemy = new ClassEntity(
//                    "Advanced Alchemy"
//            );
//
//            //Teachers
//            TeacherEntity professorAlastairHawthorne = new TeacherEntity(
//                    "Professor Alastair Hawthorne",
//                    LocalDate.of(1954, FEBRUARY, 14)
//            );
//            TeacherEntity missCassandraEvergreen = new TeacherEntity(
//                    "Miss Cassandra Evergreen",
//                    LocalDate.of(1957, MAY, 14)
//            );
//            TeacherEntity professorTheodoreBlackthorn = new TeacherEntity(
//                    "Professor Theodore Blackthorn",
//                    LocalDate.of(1957, MAY, 14)
//            );
//            TeacherEntity professorReginaldFirestone = new TeacherEntity(
//                    "Professor Reginald Firestone",
//                    LocalDate.of(1957, MAY, 14)
//            );
//
//            //Students
//            StudentEntity percy = new StudentEntity(
//                    "Percy",
//                    "percy@gmail.com",
//                    LocalDate.of(1990, MAY,5)
//            );
//            StudentEntity annabeth = new StudentEntity(
//                    "Annabeth",
//                    "annabeth@gmail.com",
//                    LocalDate.of(1995, JULY,12)
//            );
//            StudentEntity grover = new StudentEntity(
//                    "Grover",
//                    "grover@gmail.com",
//                    LocalDate.of(1998, JULY,12)
//            );
//            StudentEntity tom = new StudentEntity(
//                    "Tom",
//                    "tom@gmail.com",
//                    LocalDate.of(1998, JULY,12)
//            );
//            StudentEntity jhon = new StudentEntity(
//                    "Jhon",
//                    "aria@gmail.com",
//                    LocalDate.of(1998, JULY,12)
//            );
//            StudentEntity aria = new StudentEntity(
//                    "Aria",
//                    "aria@gmail.com",
//                    LocalDate.of(1998, JULY,12)
//            );
//            StudentEntity darius = new StudentEntity(
//                    "Darius",
//                    "darius@gmail.com",
//                    LocalDate.of(1998, JULY,12)
//            );
//            StudentEntity magnus = new StudentEntity(
//                    "Magnus",
//                    "magnus@gmail.com",
//                    LocalDate.of(1998, JULY,12)
//            );
//
//            //School
//            SchoolEntity starlightAcademy = new SchoolEntity(
//                    "Starlight Academy",
//                    "U.S"
//            );
//            SchoolEntity evergreenHigh = new SchoolEntity(
//                    "Evergreen High",
//                    "Greenland"
//            );
//            SchoolEntity ravenwoodAcademy = new SchoolEntity(
//                    "Ravenwood Academy",
//                    "U.K"
//            );
//            SchoolEntity phoenixAcademy = new SchoolEntity(
//                    "Phoenix Academy",
//                    "Japan"
//            );
//
//            professorAlastairHawthorne.setAClass(mythology);
//            missCassandraEvergreen.setAClass(cryptology);
//            professorTheodoreBlackthorn.setAClass(darkArtsDefense);
//            professorReginaldFirestone.setAClass(advancedAlchemy);
//
//            teacherRepository.saveAll(
//                    List.of(professorAlastairHawthorne,missCassandraEvergreen,professorTheodoreBlackthorn,professorReginaldFirestone)
//            );
//
//            starlightAcademy.getStudents().add(annabeth);
//            starlightAcademy.getTeachers().add(professorAlastairHawthorne);
//            starlightAcademy.getStudents().add(darius);
//            ravenwoodAcademy.getStudents().add(jhon);
//            ravenwoodAcademy.getStudents().add(tom);
//            evergreenHigh.getStudents().add(percy);
//            evergreenHigh.getStudents().add(grover);
//            phoenixAcademy.getStudents().add(magnus);
//            phoenixAcademy.getStudents().add(aria);
//
//            schoolRepository.saveAll(
//                    List.of(starlightAcademy, ravenwoodAcademy, evergreenHigh, phoenixAcademy)
//            );
//
////            SchoolEntity sch1 = new SchoolEntity();
////            sch1.setName("Weill");
////            sch1.setAddress("Cl 01");
////            schoolRepository.save(sch1);
////
////            TeacherEntity tch1 = new TeacherEntity();
////            tch1.setName("Ttt");
////            tch1.setTeacherSchool(sch1);
////            teacherRepository.save(tch1);
//
//        };
//
//    }
}
