package com.steve.hibernate.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.steve.hibernate.models.Version;

@Repository
public interface VersionRepository extends JpaRepository<Version, Long> {
	
	@Query(value = "SELECT * FROM questions AS q" + 
			"	JOIN question_version_mapping" + 
			"		AS qvm ON q.q_id = qvm.question_id" + 
			"	JOIN version" + 
			"		AS v ON qvm.version_id = v.v_id" + 
			"	LEFT JOIN answers AS a ON q.q_id = a.id_question" + 
			"	WHERE v.v_id = 3", nativeQuery = true)
	public List<Object> getAllQuestionsAndAnswersOfVersion();

}