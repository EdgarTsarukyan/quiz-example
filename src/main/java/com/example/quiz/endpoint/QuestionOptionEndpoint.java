package com.example.quiz.endpoint;

import com.example.quiz.dto.questionOptionDto.QuestionOptionDto;
import com.example.quiz.entity.QuestionOption;
import com.example.quiz.service.QuestionOptionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuestionOptionEndpoint {

    private final QuestionOptionService questionOptionService;

    @GetMapping("/quiz/question/questionOption")
    @Operation(summary = "find all question options")
    public List<QuestionOptionDto> question() {
        return questionOptionService.getAllQuestionOptions();
    }

    @PostMapping("/quiz/question/questionOption")
    @Operation(summary = "save question option")
    public QuestionOptionDto saveQuestionOption(@RequestBody QuestionOption questionOption) {
        return questionOptionService.createQuestionOption(questionOption);
    }

}
