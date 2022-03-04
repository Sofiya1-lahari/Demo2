package com.javademo.springboot.Exception;

public class UserNotFoundException  extends Exception{

    public UserNotFoundException(String message)
        {
            super(message);
        }
    
}
