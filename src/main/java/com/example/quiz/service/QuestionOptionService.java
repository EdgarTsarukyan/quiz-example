package com.example.quiz.service;

import com.example.quiz.dto.questionOptionDto.QuestionOptionDto;
import com.example.quiz.entity.QuestionOption;

import java.util.List;

public interface QuestionOptionService {
    List<QuestionOptionDto> getAllQuestionOptions();

    QuestionOptionDto createQuestionOption(QuestionOption questionOption);

}
