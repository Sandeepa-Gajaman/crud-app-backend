package com.sandeepa.crudapp.config;

import com.sandeepa.crudapp.dto.StudentDTO;
import com.sandeepa.crudapp.repository.StudentRepository;
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
            StudentDTO sandu = new StudentDTO(
                    "Sandu",
                    "sandu@gmail.com",
                    LocalDate.of(1990, MAY,5)
            );

            StudentDTO amal = new StudentDTO(
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
