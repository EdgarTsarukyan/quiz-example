package com.example.quiz.repository;


import com.example.quiz.entity.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionOptionRepository extends JpaRepository<QuestionOption, Integer> {


}
