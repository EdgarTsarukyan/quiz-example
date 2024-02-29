package com.example.quiz.service.impl;

import com.example.quiz.dto.questionDto.QuestionDto;
import com.example.quiz.dto.quizDto.GetQuizDto;
import com.example.quiz.dto.quizDto.SaveQuizDto;
import com.example.quiz.entity.Question;
import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.repository.QuizRepository;
import com.example.quiz.service.QuestionService;
import com.example.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<QuestionDto> getAllQuestions() {
        List<Question> all = questionRepository.findAll();
        return all.stream()
                .map(question -> modelMapper.map(question, QuestionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDto createQuestion(Question question) {
        return modelMapper.map(questionRepository.save(question), QuestionDto.class);
    }
}
