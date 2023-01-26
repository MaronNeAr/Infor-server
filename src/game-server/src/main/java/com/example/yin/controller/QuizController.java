package com.example.yin.controller;

import com.example.yin.config.common.SuccessMessage;
import com.example.yin.domain.Quiz;
import com.example.yin.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {
    @Autowired
    QuizService quizService;

    @GetMapping("/quiz")
    public Object getQuiz() {
        return new SuccessMessage<List<Quiz>>(null, quizService.getQuiz()).getMessage();
    }
}
