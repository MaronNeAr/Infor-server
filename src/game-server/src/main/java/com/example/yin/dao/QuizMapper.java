package com.example.yin.dao;

import com.example.yin.domain.Quiz;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizMapper {
    List<Quiz> getQuiz();
}
