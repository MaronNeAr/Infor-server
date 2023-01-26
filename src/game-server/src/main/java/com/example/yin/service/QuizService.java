package com.example.yin.service;

import com.example.yin.dao.QuizMapper;
import com.example.yin.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizMapper quizMapper;

    public List<Quiz> getQuiz() {
        return quizMapper.getQuiz();
    }
}
