package com.example.demo.controller;
import com.example.demo.model.question;
import com.example.demo.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {
    @Autowired
    private questionService questionService;

    @PostMapping("/saveQuestion")
    public question saveQuestion(question question) {
        return questionService.saveQuestion(question);
    }

    @GetMapping("/getQuestionById/{id}")
    public question findMathQuestionById(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/getQuestionsByType/{type}")
    public List<question> findAllByType(@PathVariable String type) {
        return questionService.getQuestionByType(type);
    }

    @GetMapping("/getQuestionByDifficultyAndType/{type}/{difficulty}")
    public List<question> findALlByTypeAndDifficulty(@PathVariable String type, @PathVariable int difficulty){
        return questionService.getQuestionByDifficultyAndType(type, difficulty);
    }

    @GetMapping("/buildQuiz/{type}/{difficulty}")
    public List<question> buildQuiz(@PathVariable String type, @PathVariable int difficulty) {
        int quizSize = 10;
        List<question> questions = findALlByTypeAndDifficulty(type,difficulty);
        int size = questions.size();

        List<Integer> list = ThreadLocalRandom.current()
                .ints(1, size)
                .boxed()
                .distinct()
                .limit(quizSize)
                .collect(Collectors.toList());
        List<question> quiz = new ArrayList<>();
        for (int i = 0; i < quizSize; i++) {
            quiz.add(questions.get(list.get(i)));
        }
        return  quiz;
    }
}
