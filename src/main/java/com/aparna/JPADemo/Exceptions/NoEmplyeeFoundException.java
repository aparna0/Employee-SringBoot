package com.aparna.JPADemo.Exceptions;

import org.springframework.stereotype.Component;

public class NoEmplyeeFoundException extends RuntimeException{
    public NoEmplyeeFoundException(String errorMsg){
        super(errorMsg);
    }
}
