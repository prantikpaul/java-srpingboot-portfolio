package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Custom query methods can be added here if needed
}