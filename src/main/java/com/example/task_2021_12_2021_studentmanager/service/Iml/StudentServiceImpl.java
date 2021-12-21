package com.example.task_2021_12_2021_studentmanager.service.Iml;

import com.example.task_2021_12_2021_studentmanager.exception.StudentAlreadyExistedException;
import com.example.task_2021_12_2021_studentmanager.exception.StudentNotFoundException;
import com.example.task_2021_12_2021_studentmanager.model.Student;
import com.example.task_2021_12_2021_studentmanager.repository.StudentRepository;
import com.example.task_2021_12_2021_studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ThrowableNotThrown")
@Service("StudentManagerService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    public StudentRepository studentRepository;

    //get all students
    @Override
    public List<Student> getAllStudent() {
        return new ArrayList<Student>(studentRepository.findAll());
    }

    // getting a specific record
    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void saveStudent(Student student) throws StudentAlreadyExistedException {
        if (checkEmail(student)) {
            throw new StudentAlreadyExistedException("Student with email = " + student.getEmail() + " already existed.");
        } else {
            studentRepository.save(student);
        }
    }

    @Override
    public void updateStudent(int id, Student student) throws StudentNotFoundException {
        Student update = studentRepository.findById(id).orElse(null);
        if (update == null) {
            throw new StudentNotFoundException("Student with id = " + id + " has not existed in DB");
        } else {
            update.setId(id);
            update.setEmail(student.getEmail());
            update.setAddress(student.getAddress());
            update.setName(student.getName());
            update.setBirth_date(student.getBirth_date());
            studentRepository.save(update);
        }
    }

    //deleting a specific record
    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public boolean checkEmail(Student student) {
        for (Student student1 : new ArrayList<>(studentRepository.findAll())) {
            if (student.getEmail().equals(student1.getEmail())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int ageNumbers(int id) {
        return Objects.requireNonNull(studentRepository.findById(id).orElse(null)).getAge();
    }
}