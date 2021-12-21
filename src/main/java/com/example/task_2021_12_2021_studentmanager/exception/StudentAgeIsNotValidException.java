package com.example.task_2021_12_2021_studentmanager.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentAgeIsNotValidException extends Exception{
    public StudentAgeIsNotValidException(String message) {
        super(message);
    }

    public StudentAgeIsNotValidException(Throwable cause) {
        super(cause);
    }

    public StudentAgeIsNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
