package com.steve.hibernate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.steve.hibernate.models.Question;
import com.steve.hibernate.models.QuestionVersionMapping;
import com.steve.hibernate.models.Version;
import com.steve.hibernate.repository.QuestionRepository;
import com.steve.hibernate.repository.QuestionVersionMappingRepository;
import com.steve.hibernate.repository.VersionRepository;

@RestController
public class QuestionController {

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	QuestionVersionMappingRepository questionVersionMappingRepository;

	QuestionVersionMapping questionVersionMapping = new QuestionVersionMapping();

	@Autowired
	VersionRepository VersionRepository;

	// Get All Notes
	@GetMapping(value = "/question")
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	// Create a new Note
	@PostMapping("/question")
	public String createQuestion(@Valid @RequestBody Question question) {
		List<Version> versions = VersionRepository.findAll();

		for (Version version : versions) {
			if (version.getvId() == question.getvId()) {

				questionRepository.save(question);

				questionVersionMapping.setqId(question.getqId());
				questionVersionMapping.setvId(question.getvId());
				questionVersionMappingRepository.save(questionVersionMapping);

				return "Question erfolgreich angelegt.";
			}
		}
		return "Question konnte nicht angelegt werden.";
	}

}
