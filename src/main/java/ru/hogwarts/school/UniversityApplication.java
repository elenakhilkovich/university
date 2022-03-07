package ru.hogwarts.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UniversityApplication {

    public static void main(String[] args) {

        SpringApplication.run(UniversityApplication.class, args);
        final List<Student> students = new ArrayList<>();
        final List<Faculty> faculties = new ArrayList<>();
         }
}
