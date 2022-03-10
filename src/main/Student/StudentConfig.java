package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mason = new Student(
                    "Mason",
                    "mason.jing@uwaterloo.ca",
                    LocalDate.of(2001, Month.NOVEMBER, 21));

            Student mariam = new Student(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5));

            repository.saveAll(
                    List.of(mason, mariam));
        };
    }
}
