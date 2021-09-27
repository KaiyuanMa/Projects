package com.example.demo.service;

import com.example.demo.model.question;
import com.example.demo.repository.questionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class questionService {

    @Autowired
    private questionRepository repository;

    public question saveQuestion(question question) {
        return repository.save(question);
    }

    public question getQuestionById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<question> getQuestionByType (String type) {
        return repository.findALlByType(type);
    }

    public List<question> getQuestionByDifficultyAndType (String type, int difficulty) {
        return repository.findALlByTypeAndDifficulty(type, difficulty);
    }
}
