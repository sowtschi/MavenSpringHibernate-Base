package com.steve.hibernate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steve.hibernate.models.QuestionVersionMapping;;

@Repository
public interface QuestionVersionMappingRepository extends JpaRepository<QuestionVersionMapping, Long> {

}