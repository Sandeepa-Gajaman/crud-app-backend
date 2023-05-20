package com.sandeepa.crudapp.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student sandu = new Student(
                    "Sandu",
                    "sandu@gmail.com",
                    LocalDate.of(1990, MAY,5)
            );

            Student amal = new Student(
                    "amal",
                    "amal@gmail.com",
                    LocalDate.of(1995, JULY,12)
            );

            repository.saveAll(
                    List.of(sandu,amal)
            );

        };
    }
}
