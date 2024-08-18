package org.revature.springboot.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.revature.springboot.dao.TaskRepository;
import org.revature.springboot.model.Task;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task task1;
    private Task task2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        task1 = new Task();
        task1.setId(1L);
        task1.setTaskName("Task 1");

        task2 = new Task();
        task2.setId(2L);
        task2.setTaskName("Task 2");
    }

    @Test
    void testGetAllTasks() {
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        List<Task> tasks = taskService.getAllTasks();

        assertNotNull(tasks);
        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void testGetTaskById() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task1));

        Task task = taskService.getTaskById(1L);

        assertNotNull(task);
        assertEquals("Task 1", task.getTaskName());
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateTask() {
        when(taskRepository.save(task1)).thenReturn(task1);

        Task createdTask = taskService.createTask(task1);

        assertNotNull(createdTask);
        assertEquals("Task 1", createdTask.getTaskName());
        verify(taskRepository, times(1)).save(task1);
    }

    @Test
    void testUpdateTask() {
        when(taskRepository.save(task1)).thenReturn(task1);

        Task updatedTask = taskService.updateTask(task1);

        assertNotNull(updatedTask);
        assertEquals("Task 1", updatedTask.getTaskName());
        verify(taskRepository, times(1)).save(task1);
    }

    @Test
    void testDeleteTask() {
        doNothing().when(taskRepository).deleteById(1L);

        taskService.deleteTask(1L);

        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetTasksByAssigneeId() {
        when(taskRepository.findByAssigneeId(1L)).thenReturn(Arrays.asList(task1, task2));

        List<Task> tasks = taskService.getTasksByAssigneeId(1L);

        assertNotNull(tasks);
        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).findByAssigneeId(1L);
    }

    @Test
    void testGetTasksByProjectId() {
        when(taskRepository.findByProjectId(1L)).thenReturn(Arrays.asList(task1, task2));

        List<Task> tasks = taskService.getTasksByProjectId(1L);

        assertNotNull(tasks);
        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).findByProjectId(1L);
    }
}

