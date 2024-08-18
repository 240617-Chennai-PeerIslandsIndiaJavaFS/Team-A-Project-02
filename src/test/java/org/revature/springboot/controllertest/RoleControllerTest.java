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
public class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllRoles() throws Exception {
        mockMvc.perform(get("/api/roles"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetRoleById() throws Exception {
        mockMvc.perform(get("/api/roles/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateRole() throws Exception {
        String roleJson = "{\"roleName\":\"Test Role\"}";
        mockMvc.perform(post("/api/roles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(roleJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateRole() throws Exception {
        String roleJson = "{\"id\":1,\"roleName\":\"Updated Role\"}";
        mockMvc.perform(put("/api/roles/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(roleJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteRole() throws Exception {
        mockMvc.perform(delete("/api/roles/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testGetUsersByRoleId() throws Exception {
        mockMvc.perform(get("/api/roles/1/users"))
                .andExpect(status().isOk());
    }
}
