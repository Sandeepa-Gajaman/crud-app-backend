package com.sandeepa.crudapp.config;

import com.sandeepa.crudapp.entities.SchoolEntity;
import com.sandeepa.crudapp.entities.StudentEntity;
import com.sandeepa.crudapp.repositories.SchoolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentDataConfig {

    @Bean
    CommandLineRunner commandLineRunner1(SchoolRepository repository) {
        return args -> {
            StudentEntity sandu = new StudentEntity(
                    "Sandun",
                    "sandun@gmail.com",
                    LocalDate.of(1990, MAY,5)
            );

            StudentEntity amal = new StudentEntity(
                    "Amal",
                    "amal@gmail.com",
                    LocalDate.of(1995, JULY,12)
            );

            StudentEntity kasun = new StudentEntity(
                    "Kasun",
                    "kasun@gmail.com",
                    LocalDate.of(1998, JULY,12)
            );

            //Schools
            SchoolEntity mahanama = new SchoolEntity(
                    "Mahanama Collage",
                    "Colombo 03"
            );

            SchoolEntity royal = new SchoolEntity(
                    "Royal Collage",
                    "Colombo 07"
            );

            mahanama.getStudents().add(sandu);
            royal.getStudents().add(amal);
            mahanama.getStudents().add(kasun);

            repository.saveAll(
                    List.of(mahanama,royal)
            );

        };
    }
}
