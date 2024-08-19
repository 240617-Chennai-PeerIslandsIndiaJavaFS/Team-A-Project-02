//package org.revature.springboot.controllertest;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.revature.springboot.controller.ClientController;
//import org.revature.springboot.model.Client;
//import org.revature.springboot.service.ClientService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import java.util.Arrays;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//@WebMvcTest(ClientController.class)
//public class ClientControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ClientService clientService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private Client client;
//
//    @BeforeEach
//    public void setup() {
//        client = new Client(1L, "ClientName", "ClientInfo");
//    }
//
//    @Test
//    public void testGetAllClients() throws Exception {
//        when(clientService.getAllClients()).thenReturn(Arrays.asList(client));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/clients")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].clientName").value("ClientName"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].clientInfo").value("ClientInfo"))
//                .andDo(print());
//    }
//
//    @Test
//    public void testGetClientById() throws Exception {
//        when(clientService.getClientById(anyLong())).thenReturn(client);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/clients/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.clientName").value("ClientName"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.clientInfo").value("ClientInfo"))
//                .andDo(print());
//    }
//
//    @Test
//    public void testCreateClient() throws Exception {
//        when(clientService.createClient(any(Client.class))).thenReturn(client);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/clients")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(client)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.clientName").value("ClientName"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.clientInfo").value("ClientInfo"))
//                .andDo(print());
//    }
//
//    @Test
//    public void testUpdateClient() throws Exception {
//        when(clientService.updateClient(any(Client.class))).thenReturn(client);
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/clients/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(client)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.clientName").value("ClientName"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.clientInfo").value("ClientInfo"))
//                .andDo(print());
//    }
//
//    @Test
//    public void testDeleteClient() throws Exception {
//        doNothing().when(clientService).deleteClient(anyLong());
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/clients/1"))
//                .andExpect(MockMvcResultMatchers.status().isNoContent())
//                .andDo(print());
//    }
//}
