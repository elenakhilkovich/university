package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exceptions.NotFoundFacultyException;
import ru.hogwarts.school.model.Faculty;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long lastId = 0;

    @Override
    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        faculties.put(lastId, faculty);
        return faculty;
    }

    @Override
    public Faculty findFaculty(long id) {
        Faculty faculty = faculties.get(id);
        if (faculty == null) {
            throw new NotFoundFacultyException();
        }
        return faculty;
    }

    @Override
    public Faculty editFaculty(Faculty faculty) {
        if (faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        throw new NotFoundFacultyException();
    }

    @Override
    public Faculty deleteFaculty(long id) {
        if (faculties.containsKey(id)) {
            return faculties.remove(id);
        }
        throw new NotFoundFacultyException();
    }

    @Override
    public Collection<Faculty> getAllFaculties() {
        return new HashSet<>(faculties.values());
    }

    @Override
    public Collection<Faculty> getListSameColor(String color) {
        return faculties.values().stream()
                .filter(e -> Objects.equals(e.getColor(), color))
                .collect(Collectors.toSet());
    }
}
