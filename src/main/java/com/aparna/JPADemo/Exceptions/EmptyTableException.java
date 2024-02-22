package com.aparna.JPADemo.Exceptions;

public class EmptyTableException extends RuntimeException{
    public EmptyTableException(String errorMsg){
        super(errorMsg);
    }
}
