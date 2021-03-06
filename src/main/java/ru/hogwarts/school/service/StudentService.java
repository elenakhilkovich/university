package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;


public interface StudentService {

    Student addStudent(Student student);

    Student findStudent(long id);

    Student editStudent(Student student);

    Student deleteStudent(long id);

    Collection<Student> getAllStudents();

    Collection<Student> getListSameAge(int age);
}
