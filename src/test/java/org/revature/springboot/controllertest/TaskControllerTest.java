package org.revature.springboot.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllTasks() throws Exception {
        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk());
    }

//    @Test
//    public void testGetTaskById() throws Exception {
//        mockMvc.perform(get("/api/tasks/1"))
//                .andExpect(status().isOk());
//    }

    @Test
    public void testCreateTask() throws Exception {
        String taskJson = "{\"taskName\":\"Test Task\",\"description\":\"Test description\",\"status\":\"New\",\"estimatedEffort\":10,\"actualEffort\":5,\"milestone\":\"Test milestone\"}";
        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(taskJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateTask() throws Exception {
        String taskJson = "{\"id\":1,\"taskName\":\"Updated Task\",\"description\":\"Updated description\",\"status\":\"In Progress\",\"estimatedEffort\":10,\"actualEffort\":5,\"milestone\":\"Updated milestone\"}";
        mockMvc.perform(put("/api/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(taskJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteTask() throws Exception {
        mockMvc.perform(delete("/api/tasks/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testGetTasksByAssigneeId() throws Exception {
        mockMvc.perform(get("/api/tasks/assignee/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTasksByProjectId() throws Exception {
        mockMvc.perform(get("/api/tasks/project/1"))
                .andExpect(status().isOk());
    }
}
