package com.portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.portfolio.model.Project;
import com.portfolio.repository.ProjectRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProjectRepository projectRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Add sample projects if the database is empty
        if (projectRepository.count() == 0) {
            Project project1 = new Project();
            project1.setTitle("Portfolio Website");
            project1.setDescription("A personal portfolio website built with Spring Boot and Thymeleaf.");
            project1.setImageUrl("/images/portfolio.svg");
            project1.setProjectUrl("#");
            project1.setGithubUrl("https://github.com/yourusername/portfolio");
            project1.setTechnologies("Java, Spring Boot, Thymeleaf, H2 Database, Bootstrap");
            project1.setDate("2023");
            
            Project project2 = new Project();
            project2.setTitle("E-commerce Platform");
            project2.setDescription("A full-featured e-commerce platform with product management, shopping cart, and payment integration.");
            project2.setImageUrl("/images/ecommerce.svg");
            project2.setProjectUrl("#");
            project2.setGithubUrl("https://github.com/yourusername/ecommerce");
            project2.setTechnologies("Java, Spring Boot, React, MySQL, REST API");
            project2.setDate("2022");
            
            Project project3 = new Project();
            project3.setTitle("Task Management App");
            project3.setDescription("A task management application with user authentication, task creation, and progress tracking.");
            project3.setImageUrl("/images/taskmanager.svg");
            project3.setProjectUrl("#");
            project3.setGithubUrl("https://github.com/yourusername/taskmanager");
            project3.setTechnologies("Java, Spring Boot, Angular, PostgreSQL");
            project3.setDate("2021");
            
            projectRepository.save(project1);
            projectRepository.save(project2);
            projectRepository.save(project3);
        }
    }
}