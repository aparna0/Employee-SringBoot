package com.aparna.JPADemo.Exceptions;

public class DuplicateEmployeeException extends RuntimeException{
    public DuplicateEmployeeException(String errorMsg){
        super(errorMsg);
    }

}
