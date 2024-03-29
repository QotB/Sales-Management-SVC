package com.example.demo.service.client_management.boundry;


import com.example.demo.service.client_management.control.ClientController;
import com.example.demo.service.client_management.entity.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientResource {

    @Autowired
    private ClientController clientService;

    @GetMapping
    public List<ClientModel> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody ClientModel client) {
        clientService.createClient(client);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<?> updateClient(@PathVariable String clientId, @RequestBody ClientModel client) {
        clientService.updateClient(clientId, client);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable String clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.ok().build();
    }

}
