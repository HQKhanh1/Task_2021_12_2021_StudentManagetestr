package com.example.task_2021_12_2021_studentmanager.service;

import com.example.task_2021_12_2021_studentmanager.exception.StudentAlreadyExistedException;
import com.example.task_2021_12_2021_studentmanager.exception.StudentNotFoundException;
import com.example.task_2021_12_2021_studentmanager.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();

    Student getStudentById(int id);

    void saveStudent(Student student) throws StudentAlreadyExistedException;

    void updateStudent(int id, Student student) throws StudentNotFoundException;

    void deleteStudent(int id);

    boolean checkEmail(Student student);

    int ageNumbers(int id);

//    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
}
