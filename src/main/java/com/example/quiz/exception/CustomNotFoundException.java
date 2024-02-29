package com.example.quiz.exception;

public class CustomNotFoundException extends RuntimeException {

    public CustomNotFoundException(String massage) {
        super(massage);
    }

}
