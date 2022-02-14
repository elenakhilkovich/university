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
        final List<Student> students = new ArrayList<>();
        final List<Faculty> faculties = new ArrayList<>();

        SpringApplication.run(UniversityApplication.class, args);
        Student student1 = new Student(1, "Федоров Федор", 18);
        Student student2 = new Student(2, "Петров Петр", 19);
        Student student3 = new Student(3, "Сидоров Сидор", 20);

        students.add(student1);
        students.add(student2);
        students.add(student3);


        Faculty faculty1 = new Faculty(11, "Факультет дорожного строительства", "серый");
        Faculty faculty2 = new Faculty(22, "Факультет автотракторный", "коричневый");
        Faculty faculty3 = new Faculty(33, "Факультет строительный", "красный");

        faculties.add(faculty1);
        faculties.add(faculty2);
        faculties.add(faculty3);

        System.out.println(students);
        System.out.println(faculties);
    }

}
