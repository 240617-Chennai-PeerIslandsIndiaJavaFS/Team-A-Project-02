package org.revature.springboot.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.revature.springboot.dao.ProjectRepository;
import org.revature.springboot.model.Client;
import org.revature.springboot.model.Project;
import org.revature.springboot.model.User;
import org.revature.springboot.service.ProjectService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    void testGetAllProjects() {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1L, "Project 1", new Client(1L, "Client 1", "Info 1"), new User(1L, "User 1"), new HashSet<>()));
        projects.add(new Project(2L, "Project 2", new Client(2L, "Client 2", "Info 2"), new User(2L, "User 2"), new HashSet<>()));

        when(projectRepository.findAll()).thenReturn(projects);

        List<Project> result = projectService.getAllProjects();

        assertEquals(projects, result);
        verify(projectRepository).findAll();
    }

    @Test
    void testGetProjectById() {
        Project project = new Project(1L, "Project 1", new Client(1L, "Client 1", "Info 1"), new User(1L, "User 1"), new HashSet<>());

        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        Project result = projectService.getProjectById(1L);

        assertEquals(project, result);
        verify(projectRepository).findById(1L);
    }

    @Test
    void testCreateProject() {
        Project project = new Project(null, "Project 1", new Client(1L, "Client 1", "Info 1"), new User(1L, "User 1"), new HashSet<>());

        when(projectRepository.save(project)).thenReturn(new Project(1L, "Project 1", new Client(1L, "Client 1", "Info 1"), new User(1L, "User 1"), new HashSet<>()));

        Project result = projectService.createProject(project);

        assertEquals(new Project(1L, "Project 1", new Client(1L, "Client 1", "Info 1"), new User(1L, "User 1"), new HashSet<>()), result);
        verify(projectRepository).save(project);
    }

    @Test
    void testUpdateProject() {
        Project project = new Project(1L, "Project 1", new Client(1L, "Client 1", "Info 1"), new User(1L, "User 1"), new HashSet<>());

        when(projectRepository.save(project)).thenReturn(project);

        Project result = projectService.updateProject(project);

        assertEquals(project, result);
        verify(projectRepository).save(project);
    }

    @Test
    void testDeleteProject() {
        projectService.deleteProject(1L);

        verify(projectRepository).deleteById(1L);
    }
}
