package com.example.demo.service.client_management.control;

import com.example.demo.common.exceptions.ResourceNotFoundException;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.client_management.entity.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClients() {
        return clientRepository.findAll();
    }

    public void createClient(ClientModel client) {
        clientRepository.save(client);
    }

    public void updateClient(String clientId, ClientModel client) {
        ClientModel existingClient = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + clientId));
        // Update existingClient fields with the fields from client
        existingClient.setName(client.getName());
        existingClient.setLastName(client.getLastName());
        existingClient.setMobile(client.getMobile());
        existingClient.setEmail(client.getEmail());
        existingClient.setAddress(client.getAddress());
        clientRepository.save(existingClient);
    }

    public void deleteClient(String clientId) {
        clientRepository.deleteById(clientId);
    }
}
