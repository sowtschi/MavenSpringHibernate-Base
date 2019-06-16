package com.steve.hibernate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.steve.hibernate.models.Answer;
import com.steve.hibernate.models.Question;
import com.steve.hibernate.repository.AnswerRepository;
import com.steve.hibernate.repository.QuestionRepository;

@RestController
public class AnswerController {

	@Autowired
	AnswerRepository answerRepository;

	@Autowired
	QuestionRepository questionRepository;

	// Get all answers
	@GetMapping(value = "/answer")
	public List<Answer> getAllAnswers() {
		return answerRepository.findAll();
	}

	// Create a new answer
	@PostMapping("/answer")
	public String createNote(@Valid @RequestBody Answer answer) {
		List<Question> questions = questionRepository.findAll();

		for (Question question : questions) {
			if (question.getqId() == answer.getqId()) {
				answer.setQuestion(question);
				answerRepository.save(answer);
				question.setAnswer(answer);
				return "Answer successfully created.";
			}
		}

		return "Answer could not be created.";

	}

}
