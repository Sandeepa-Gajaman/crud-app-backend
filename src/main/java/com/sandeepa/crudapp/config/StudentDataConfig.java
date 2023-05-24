package com.sandeepa.crudapp.config;

import com.sandeepa.crudapp.dto.SchoolDto;
import com.sandeepa.crudapp.dto.StudentDto;
import com.sandeepa.crudapp.repository.SchoolRepository;
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
            SchoolDto mahanama = new SchoolDto(
                    "Mahanama Collage",
                    "Colombo 03"
            );

            SchoolDto royal = new SchoolDto(
                    "Royal Collage",
                    "Colombo 07"
            );

            StudentDto sandu = new StudentDto(
                    "Sandu",
                    "sandu@gmail.com",
                    LocalDate.of(1990, MAY,5)
            );

            StudentDto amal = new StudentDto(
                    "Amal",
                    "amal@gmail.com",
                    LocalDate.of(1995, JULY,12)
            );

            StudentDto kasun = new StudentDto(
                    "Kasun",
                    "kasun@gmail.com",
                    LocalDate.of(1998, JULY,12)
            );

            mahanama.getSchoolName().add(sandu);
            royal.getSchoolName().add(amal);
            mahanama.getSchoolName().add(kasun);

            repository.saveAll(
                    List.of(mahanama,royal)
            );

        };
    }
}
