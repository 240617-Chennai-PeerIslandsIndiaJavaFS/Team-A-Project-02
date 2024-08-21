package org.revature.RevTaskManagement.controller;

import org.revature.RevTaskManagement.models.Project;
import org.revature.RevTaskManagement.models.User;
import org.revature.RevTaskManagement.service.ProjectService;
import org.revature.RevTaskManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/by-username")
    public List<Project> getProjectsByUsername(@RequestParam("username") String username) {
        return projectService.getProjectsByUsername(username); // Call service method to fetch projects
    }

    @PutMapping("/{projectId}/add-team-member/{userId}")
    public ResponseEntity<String> addTeamMemberToProject(
            @PathVariable int projectId,
            @PathVariable int userId) {
        try {
            String result = projectService.addTeamMemberToProject(projectId, userId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/teamMembers")
    public Set<User> getTeamMembersByProjectName(@RequestParam String projectName) {
        return projectService.getTeamMembersByProjectName(projectName);
    }

    @GetMapping("/getTeamMembersByProjectId")
    public Set<User> getTeamMembersByProjectId(@RequestParam int projectId) {
        return projectService.getTeamMembersByProjectId(projectId);
    }
}