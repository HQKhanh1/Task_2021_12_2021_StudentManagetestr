package com.example.task_2021_12_2021_studentmanager.controller;

import com.example.task_2021_12_2021_studentmanager.exception.StudentAlreadyExistedException;
import com.example.task_2021_12_2021_studentmanager.exception.StudentNotFoundException;
import com.example.task_2021_12_2021_studentmanager.model.Student;
import com.example.task_2021_12_2021_studentmanager.repository.StudentRepository;
import com.example.task_2021_12_2021_studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student")
    private List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/page")
    public Page<Student> getStudents(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
        return studentRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        5,
                        Sort.Direction.ASC, sortBy.orElse("id")
                )
        );
    }

    @GetMapping("/student/{id}")
    private Student getStudent(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/student/{id}")
    private String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "delete successfully";
    }

    @PostMapping("/student")
    private String saveStudent(@RequestBody @Valid Student student) throws StudentAlreadyExistedException {
        studentService.saveStudent(student);
        return "save successfully";
    }

    @PutMapping("/student/{id}")
    public String updateStudent(@PathVariable("id") int id, @RequestBody @Valid Student student) throws StudentNotFoundException {
        studentService.updateStudent(id, student);
        return "update successfully";
    }

    @GetMapping("/age/{id}")
    private int getAgeStudent(@PathVariable("id") int id) {
        return studentService.ageNumbers(id);
    }
}
