package com.example.amigoscode.StudentModel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            StudentModel victoria = new StudentModel(
                    "Victoria",
                    "victoriarspaiva@gmail.com",
                    LocalDate.of(1993, Month.JANUARY, 4)
            );
            StudentModel thor = new StudentModel(
                    "Thor",
                    "thor@gmail.com",
                    LocalDate.of(2020, Month.JANUARY, 1)
            );
            StudentModel rafa = new StudentModel(
                    "Rafael",
                    "moris@gmail.com",
                    LocalDate.of(1983, Month.MAY, 4)
            );
            repository.saveAll(
                    List.of(victoria, thor, rafa)
            );
        };
    }
}
