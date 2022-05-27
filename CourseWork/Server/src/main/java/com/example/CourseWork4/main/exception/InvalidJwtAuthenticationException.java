package com.example.CourseWork4.main.exception;

public class InvalidJwtAuthenticationException extends RuntimeException
{
    public InvalidJwtAuthenticationException(String message)
    {
        super(message);
    }
}
