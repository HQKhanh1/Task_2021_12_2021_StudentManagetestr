package com.example.task_2021_12_2021_studentmanager.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
