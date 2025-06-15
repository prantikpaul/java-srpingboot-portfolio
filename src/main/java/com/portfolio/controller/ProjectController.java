package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.model.Project;
import com.portfolio.service.ProjectService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    
    @GetMapping
    public String getAllProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "projects";
    }
    
    @GetMapping("/new")
    public String showProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "project-form";
    }
    
    @PostMapping("/save")
    public String saveProject(@Valid @ModelAttribute("project") Project project, 
                             BindingResult result) {
        if (result.hasErrors()) {
            return "project-form";
        }
        
        projectService.saveProject(project);
        return "redirect:/projects";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id));
        return "project-form";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "redirect:/projects";
    }
    
    @GetMapping("/{id}")
    public String getProjectDetails(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id));
        return "project-details";
    }
}