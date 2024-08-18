package org.revature.springboot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.revature.springboot.dao.ClientRepository;
import org.revature.springboot.model.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    void testGetAllClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1L, "Client 1", "Info 1"));
        clients.add(new Client(2L, "Client 2", "Info 2"));

        when(clientRepository.findAll()).thenReturn(clients);

        List<Client> result = clientService.getAllClients();

        assertEquals(clients, result);
        verify(clientRepository).findAll();
    }

    @Test
    void testGetClientById() {
        Client client = new Client(1L, "Client 1", "Info 1");

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Client result = clientService.getClientById(1L);

        assertEquals(client, result);
        verify(clientRepository).findById(1L);
    }

    @Test
    void testCreateClient() {
        Client client = new Client(null, "Client 1", "Info 1");

        when(clientRepository.save(client)).thenReturn(new Client(1L, "Client 1", "Info 1"));

        Client result = clientService.createClient(client);

        assertEquals(new Client(1L, "Client 1", "Info 1"), result);
        verify(clientRepository).save(client);
    }

    @Test
    void testUpdateClient() {
        Client client = new Client(1L, "Client 1", "Info 1");

        when(clientRepository.save(client)).thenReturn(client);

        Client result = clientService.updateClient(client);

        assertEquals(client, result);
        verify(clientRepository).save(client);
    }

    @Test
    void testDeleteClient() {
        clientService.deleteClient(1L);

        verify(clientRepository).deleteById(1L);
    }
}
