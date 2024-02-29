package com.example.quiz.endpoint;

import com.example.quiz.dto.questionDto.QuestionDto;
import com.example.quiz.entity.Question;
import com.example.quiz.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuestionEndpoint {

    private final QuestionService questionService;

    @GetMapping("/quiz/question")
    @Operation(summary = "find all questions")
    public List<QuestionDto> question() {
        return questionService.getAllQuestions();
    }

    @PostMapping("/quiz/question")
    @Operation(summary = "question creation")
    public QuestionDto saveQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

}
