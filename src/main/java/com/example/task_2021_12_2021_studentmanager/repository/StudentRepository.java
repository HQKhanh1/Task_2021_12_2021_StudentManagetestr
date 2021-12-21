package com.example.task_2021_12_2021_studentmanager.repository;

import com.example.task_2021_12_2021_studentmanager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
}
