package com.example.quiz.exception;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String massage) {
        super(massage);
    }
}
