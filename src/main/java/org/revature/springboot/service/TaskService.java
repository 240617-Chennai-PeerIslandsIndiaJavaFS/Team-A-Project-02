package org.revature.springboot.service;

import org.revature.springboot.dao.TaskRepository;
import org.revature.springboot.dao.UserRepository;
import org.revature.springboot.exception.InvalidRoleException;
import org.revature.springboot.exception.TaskNotFoundException;
import org.revature.springboot.exception.UserNotFoundException;
import org.revature.springboot.model.Task;
import org.revature.springboot.model.User;
import org.revature.springboot.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private final TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByAssigneeId(Long assigneeId) {
        return taskRepository.findByAssigneeId(assigneeId);
    }

    public List<Task> getTasksByProjectId(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public Task updateTaskStatus(Long taskId, String newStatus) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + taskId));
        task.setStatus(newStatus);
        return taskRepository.save(task);
    }

    public Task assignTaskToTeamMember(Long taskId, Long teamMemberId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        User teamMember = userRepository.findById(teamMemberId).orElseThrow(() -> new UserNotFoundException("Team member not found"));
        if (teamMember.getRole() != UserRole.TEAM_MEMBER) {
            throw new InvalidRoleException("User is not a team member");
        }
        task.setTeamMember(teamMember);
        return taskRepository.save(task);
    }

    public List<Task> getTasksForTeamMember(Long teamMemberId) {
        User teamMember = userRepository.findById(teamMemberId).orElseThrow(() -> new UserNotFoundException("Team member not found"));
        return taskRepository.findByTeamMember(teamMember);
    }

    public List<Task> filterTasksByProject(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public List<Task> sortTasksByProject(Long projectId) {
        return taskRepository.findByProjectIdOrderByStartDateAsc(projectId);
    }
}