package com.steve.hibernate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steve.hibernate.models.Question;;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}