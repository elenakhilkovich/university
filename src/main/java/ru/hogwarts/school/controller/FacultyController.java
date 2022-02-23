package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.exceptions.BadRequestException;
import ru.hogwarts.school.exceptions.NotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculties")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public Faculty getFacultyInfo(@PathVariable long id){
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null){
            throw new BadRequestException();
        }
        return faculty;
    }
    @GetMapping
    public Collection<Faculty> getAllFaculties(){
        return facultyService.getAllFaculties();
    }
    @GetMapping("/filter/{color}")
    public Collection<Faculty> getFacultiesSameColor(@PathVariable String color){
        return facultyService.getListSameColor(color);
    }
    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty){
        return facultyService.addFaculty(faculty);
    }
    @PutMapping
    public Faculty editFaculty(@RequestBody Faculty faculty){
        Faculty editFaculty = facultyService.editFaculty(faculty);
        if (editFaculty ==null){
            throw new BadRequestException();
        }
        return editFaculty;
    }

    @DeleteMapping("{id}")
    public Faculty deleteFaculty(@PathVariable long id){
        Faculty delFaculty = facultyService.deleteFaculty(id);
        if (delFaculty == null){
            throw new NotFoundException();
        }
        return delFaculty;
    }
        }

