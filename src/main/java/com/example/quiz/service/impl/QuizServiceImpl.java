package com.example.quiz.service.impl;

import com.example.quiz.dto.quizDto.GetQuizDto;
import com.example.quiz.dto.quizDto.SaveQuizDto;
import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;
import com.example.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<GetQuizDto> getAllQuizzes() {
        List<Quiz> all = quizRepository.findAll();
        return all.stream()
                .map(quiz -> modelMapper.map(quiz, GetQuizDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SaveQuizDto createQuiz(Quiz quiz) {
        quiz.setCreated_date_time(LocalDate.now());
        return modelMapper.map(quizRepository.save(quiz), SaveQuizDto.class);
    }
}
