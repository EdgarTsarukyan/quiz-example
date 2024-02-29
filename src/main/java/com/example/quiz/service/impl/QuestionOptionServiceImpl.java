package com.example.quiz.service.impl;

import com.example.quiz.dto.questionOptionDto.QuestionOptionDto;
import com.example.quiz.entity.QuestionOption;
import com.example.quiz.repository.QuestionOptionRepository;
import com.example.quiz.service.QuestionOptionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class QuestionOptionServiceImpl implements QuestionOptionService {

    private final QuestionOptionRepository questionOptionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<QuestionOptionDto> getAllQuestionOptions() {

        return questionOptionRepository.findAll().stream()
                .map(questionOption -> modelMapper.map(questionOption, QuestionOptionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public QuestionOptionDto createQuestionOption(QuestionOption questionOption) {
        return modelMapper.map(questionOptionRepository.save(questionOption), QuestionOptionDto.class);
    }
}
