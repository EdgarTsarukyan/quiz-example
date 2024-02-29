package com.example.quiz.service.impl;

import com.example.quiz.dto.answer.GetAnswerDto;
import com.example.quiz.dto.answer.SaveAnswerDto;
import com.example.quiz.entity.Answer;
import com.example.quiz.repository.AnswerRepository;
import com.example.quiz.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<GetAnswerDto> getAllAnswers() {
        return answerRepository.findAll().stream()
                .map(questionOption -> modelMapper.map(questionOption, GetAnswerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SaveAnswerDto createQuiz(Answer answer) {
        answer.setDate_time(LocalDate.now());
        return modelMapper.map(answerRepository.save(answer), SaveAnswerDto.class);
    }
}
