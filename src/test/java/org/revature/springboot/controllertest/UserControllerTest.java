package org.revature.springboot.controllertest;

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
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk());
    }

//    @Test
//    public void testGetUserById() throws Exception {
//        mockMvc.perform(get("/api/users/1"))
//                .andExpect(status().isOk());
//    }

//    @Test
//    public void testCreateUser() throws Exception {
//        String userJson = "{\"username\":\"Test User\",\"email\":\"test@example.com\",\"password\":\"password\",\"active\":true,\"role\":{\"id\":1,\"roleName\":\"Test Role\"}}";
//        mockMvc.perform(post("/api/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(userJson))
//                .andExpect(status().isCreated());
//    }

//    @Test
//    public void testUpdateUser() throws Exception {
//        String userJson = "{\"id\":1,\"username\":\"Updated User\",\"email\":\"updated@example.com\",\"password\":\"updatedpassword\",\"active\":true,\"role\":{\"id\":1,\"roleName\":\"Test Role\"}}";
//        mockMvc.perform(put("/api/users/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(userJson))
//                .andExpect(status().isOk());
//    }

    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());
    }
}