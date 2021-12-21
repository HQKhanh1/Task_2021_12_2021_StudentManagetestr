package com.example.task_2021_12_2021_studentmanager.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentAlreadyExistedException extends Exception {
    public StudentAlreadyExistedException(String message) {
        super(message);
    }

}
