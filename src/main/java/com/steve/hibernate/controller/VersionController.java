package com.steve.hibernate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.steve.hibernate.models.Version;
import com.steve.hibernate.repository.AnswerRepository;
import com.steve.hibernate.repository.VersionRepository;

@RestController
public class VersionController {

	@Autowired
	AnswerRepository answerRepository;

	@Autowired
	VersionRepository versionRepository;

	// Get version-data
	@GetMapping(value = "/version")
	public List<Object> getAllAnswers(@RequestParam String id) {
		List<Object> questionsAndAnswers = versionRepository.getAllQuestionsAndAnswersOfVersion();
		return questionsAndAnswers;
	}

	// create a new Version
	@PostMapping("/version")
	public Version createVersion(@Valid @RequestBody Version version) {
		return versionRepository.save(version);

	}

}
