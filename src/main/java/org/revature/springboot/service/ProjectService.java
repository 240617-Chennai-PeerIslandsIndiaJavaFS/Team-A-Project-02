package org.revature.springboot.service;

import org.revature.springboot.dao.ClientRepository;
import org.revature.springboot.dao.ProjectRepository;
import org.revature.springboot.dao.TaskRepository;
import org.revature.springboot.exception.ProjectNotFoundException;
import org.revature.springboot.exception.ResourceNotFoundException;
import org.revature.springboot.model.Project;
import org.revature.springboot.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private final ProjectRepository projectRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow();
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Project viewProjectDetails(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException("Project not found"));
        List<Task> tasks = taskRepository.findByProjectId(projectId);
        project.setTasks(tasks);
        return project;
    }
}
