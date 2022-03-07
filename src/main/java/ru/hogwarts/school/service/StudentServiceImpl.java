package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exceptions.NotFoundStudentException;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Long, Student> students = new HashMap<>();

    private long lastId = 0;


    @Override
    public Student addStudent(Student student) {
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    @Override
    public Student findStudent(long id) {
        Student student = students.get(id);
        if (student == null) {
            throw new NotFoundStudentException();
        }
        return student;
    }

    @Override
    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        throw new NotFoundStudentException();     //("такого студента нет")
    }

    @Override
    public Student deleteStudent(long id) {
        if (students.containsKey(id)) {
            return students.remove(id);
        }
        throw new NotFoundStudentException();           //("такого студента нет")
    }

    @Override
    public Collection<Student> getAllStudents() {
        return new HashSet<>(students.values());
    }

    @Override
    public Collection<Student> getListSameAge(int age) {
        return students.values()
                .stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toSet());
    }
}
