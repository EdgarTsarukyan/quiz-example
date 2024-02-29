package com.example.quiz.endpoint;

import com.example.quiz.dto.quizDto.GetQuizDto;
import com.example.quiz.dto.quizDto.SaveQuizDto;
import com.example.quiz.entity.Quiz;
import com.example.quiz.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuizEndpoint {

    private final QuizService quizService;

    @GetMapping("/quiz")
    @Operation(summary = "find all quizzes")
    public List<GetQuizDto> quiz() {
        return quizService.getAllQuizzes();
    }

    @PostMapping("/quiz")
    @Operation(summary = "quiz creation")
    public SaveQuizDto quiz(@RequestBody Quiz quiz) {
        quiz.setCreated_date_time(LocalDate.now());
        return quizService.createQuiz(quiz);
    }

}
