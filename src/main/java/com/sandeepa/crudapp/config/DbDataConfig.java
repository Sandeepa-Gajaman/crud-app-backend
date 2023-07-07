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
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
@AllArgsConstructor
public class DbDataConfig {

    @Bean
    public ApplicationRunner initData(SchoolRepository schoolRepository, StudentRepository studentRepository,
                                      TeacherRepository teacherRepository, ClassRepository classRepository) {
        return args -> {

            //School
//
//            SchoolEntity evergreenHigh = new SchoolEntity(
//                    "Evergreen High",
//                    "Greenland"
//            );
//            SchoolEntity phoenixAcademy = new SchoolEntity(
//                    "Phoenix Academy",
//                    "Japan"
//            );
//
            SchoolEntity starlightAcademy = new SchoolEntity();
            starlightAcademy.setName("Starlight Academy");
            starlightAcademy.setAddress("U.S");

            SchoolEntity evergreenHigh = new SchoolEntity();
            evergreenHigh.setName("Evergreen High");
            evergreenHigh.setAddress("U.K");

            schoolRepository.saveAll(
                    List.of(starlightAcademy,evergreenHigh)
            );

            //Teachers
            TeacherEntity professorAlastairHawthorne = new TeacherEntity();
            professorAlastairHawthorne.setName("Professor Alastair Hawthorne");
            professorAlastairHawthorne.setDob(LocalDate.of(1957, MAY, 11));
            professorAlastairHawthorne.setSchool(evergreenHigh);

            TeacherEntity missCassandraEvergreen = new TeacherEntity();
            missCassandraEvergreen.setName("Miss Cassandra Evergreen");
            missCassandraEvergreen.setDob(LocalDate.of(1954, JUNE, 10));
            missCassandraEvergreen.setSchool(starlightAcademy);

            TeacherEntity professorTheodoreBlackthorn = new TeacherEntity();
            professorTheodoreBlackthorn.setName("Professor Theodore Blackthorn");
            professorTheodoreBlackthorn.setDob(LocalDate.of(1957, MAY, 24));
            professorTheodoreBlackthorn.setSchool(starlightAcademy);

            TeacherEntity professorReginaldFirestone = new TeacherEntity();
            professorReginaldFirestone.setName("Professor Reginald Firestone");
            professorReginaldFirestone.setDob(LocalDate.of(1957, MAY, 12));
            professorReginaldFirestone.setSchool(evergreenHigh);

            teacherRepository.saveAll(
                    List.of(professorAlastairHawthorne,missCassandraEvergreen,professorTheodoreBlackthorn,
                            professorReginaldFirestone)
            );

            //Classes
            ClassEntity mythology = new ClassEntity();
            mythology.setName("Mythology");
            mythology.setTeacher(professorReginaldFirestone);

            ClassEntity darkArtsDefense = new ClassEntity();
            darkArtsDefense.setName("Dark Arts Defense");
            darkArtsDefense.setTeacher(professorTheodoreBlackthorn);

            ClassEntity cryptology = new ClassEntity();
            cryptology.setName("Cryptology");
            cryptology.setTeacher(professorAlastairHawthorne);

            ClassEntity advancedAlchemy = new ClassEntity();
            advancedAlchemy.setName("Advanced Alchemy");
            advancedAlchemy.setTeacher(missCassandraEvergreen);

            classRepository.saveAll(
                    List.of(mythology, darkArtsDefense, cryptology, advancedAlchemy)
            );

            //Students
            StudentEntity grover = new StudentEntity();
            grover.setName("Grover");
            grover.setEmail("grover@gmail.com");
            grover.setDob(LocalDate.of(1998, JULY,12));
            grover.setSchool(evergreenHigh);
            grover.setAClass(mythology);

            StudentEntity annabeth = new StudentEntity();
            annabeth.setName("Annabeth");
            annabeth.setEmail("annabeth@gmail.com");
            annabeth.setDob(LocalDate.of(1997, JANUARY,01));
            annabeth.setSchool(starlightAcademy);
            annabeth.setAClass(darkArtsDefense);

            StudentEntity tom = new StudentEntity();
            tom.setName("Tom");
            tom.setEmail("tom@gmail.com");
            tom.setDob(LocalDate.of(1995, APRIL,26));
            tom.setSchool(evergreenHigh);
            tom.setAClass(cryptology);

            StudentEntity jhon = new StudentEntity();
            jhon.setName("Jhon");
            jhon.setEmail("jhon@gmail.com");
            jhon.setDob(LocalDate.of(1996, DECEMBER,31));
            jhon.setSchool(starlightAcademy);
            jhon.setAClass(darkArtsDefense);

            StudentEntity aria = new StudentEntity();
            aria.setName("Aria");
            aria.setEmail("aria@gmail.com");
            aria.setDob(LocalDate.of(1991, MARCH,07));
            aria.setSchool(evergreenHigh);
            aria.setAClass(cryptology);

            StudentEntity tony = new StudentEntity();
            aria.setName("Tony");
            aria.setEmail("tony@gmail.com");
            aria.setDob(LocalDate.of(1992, JANUARY,17));
            aria.setSchool(evergreenHigh);
            aria.setAClass(darkArtsDefense);

            StudentEntity clara = new StudentEntity();
            aria.setName("Clarai");
            aria.setEmail("clarai@gmail.com");
            aria.setDob(LocalDate.of(1996, FEBRUARY,17));
            aria.setSchool(evergreenHigh);
            aria.setAClass(darkArtsDefense);

            studentRepository.saveAll(
                    List.of(grover, annabeth, tom, jhon, aria, tony, clara)
            );
        };

    }
}
