package com.steve.hibernate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steve.hibernate.models.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}