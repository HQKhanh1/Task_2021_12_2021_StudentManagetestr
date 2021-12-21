package com.example.task_2021_12_2021_studentmanager.exception;

import com.example.task_2021_12_2021_studentmanager.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@SuppressWarnings("ALL")
@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(MethodArgumentNotValidException ex, WebRequest request) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getBindingResult().getFieldError().getDefaultMessage(), new Date(), request.getDescription(false));
    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage StudentNotFoundException(StudentNotFoundException ex, WebRequest request) {
        return new ErrorMessage(400, ex.getMessage(), new Date());
    }

    @ExceptionHandler(StudentAlreadyExistedException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage StudentAlreadyExistedException(StudentAlreadyExistedException ex, WebRequest request) {
        return new ErrorMessage(404, ex.getMessage(), new Date());
    }
}
