package com.example.quiz.endpoint;

import com.example.quiz.dto.answer.GetAnswerDto;
import com.example.quiz.dto.answer.SaveAnswerDto;
import com.example.quiz.entity.Answer;
import com.example.quiz.service.AnswerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnswerEndpoint {

    private final AnswerService answerService;

    @GetMapping("/quiz/question/questionOption/Answer")
    @Operation(summary = "find all answers")
    public List<GetAnswerDto> question() {
        return answerService.getAllAnswers();
    }

    @PostMapping("/quiz/question/questionOption/Answer")
    @Operation(summary = "saving answer")
    public SaveAnswerDto saveQuestionOption(@RequestBody Answer answer) {
        return answerService.createQuiz(answer);
    }

}
