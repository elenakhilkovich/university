package ru.hogwarts.school.service;

import org.springframework.context.annotation.Bean;
import ru.hogwarts.school.exceptions.NotFoundException;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();

    private long lastId = 0;


    public Student addStudent(Student student) {
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    public Student findStudent(long id) {
        return students.get(id);
    }

    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        throw new NotFoundException();     //("такого студента нет")
    }

    public Student deleteStudent(long id) {
        if (students.containsKey(id)) {
            return students.remove(id);
        }
        throw new NotFoundException();           //("такого студента нет")
    }

    public Collection<Student> getAllStudents() {
        return new HashSet<>(students.values());
    }

    public Collection<Student> getListSameAge(int age) {
        return students.values()
                .stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toSet());
    }
}
