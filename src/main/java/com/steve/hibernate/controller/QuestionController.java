package com.steve.hibernate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.steve.hibernate.models.Question;
import com.steve.hibernate.repository.QuestionRepository;

@RestController
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

 // Get All Notes
    @GetMapping(value = "/question")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    
 // Create a new Note
    @PostMapping("/question")
    public Question createQuestion(@Valid @RequestBody Question question) {
        return questionRepository.save(question);
    }
    
}
