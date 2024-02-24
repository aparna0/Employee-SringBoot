package com.aparna.JPADemo.ExceptionHandler;

import com.aparna.JPADemo.Exceptions.DuplicateEmployeeException;
import com.aparna.JPADemo.Exceptions.EmptyTableException;
import com.aparna.JPADemo.Exceptions.NoEmplyeeFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(value = EmptyTableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseStatusException handleEmptyTableException(EmptyTableException ex){
        return new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
    }

    @ExceptionHandler( value = NoEmplyeeFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseStatusException handleNoEmployeeException(NoEmplyeeFoundException ex){
        return new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(),ex);
    }

    @ExceptionHandler( value = DuplicateEmployeeException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseStatusException handleDuplicateEmployeeException(DuplicateEmployeeException ex){
        return new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
    }
}
