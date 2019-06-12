package com.steve.hibernate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steve.hibernate.models.Version;

@Repository
public interface VersionRepository extends JpaRepository<Version, Long> {

}