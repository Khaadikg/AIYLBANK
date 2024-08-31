package com.aiylbank.demo.web.common;

import com.aiylbank.demo.web.common.exception.ExceptionResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Validated
public class BaseEntityController {

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse onNotFoundException(ChangeSetPersister.NotFoundException e) {
        return new ExceptionResponse(HttpStatus.NOT_FOUND, e.getClass().getName(), e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ExceptionResponse> onConstraintValidationException(
            ConstraintViolationException e
    ) {
        return e.getConstraintViolations().stream()
                .map(
                        violation -> new ExceptionResponse(
                                HttpStatus.BAD_REQUEST,
                                violation.getPropertyPath().toString(),
                                violation.getMessage()
                        )
                )
                .toList();
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse onException(ChangeSetPersister.NotFoundException e) {
        return new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getClass().getName(), e.getMessage());
    }

}
