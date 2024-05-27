package com.example.invoice.web;


import com.example.invoice.dto.ClientDTO;
import com.example.invoice.service.ClientService;
import com.example.invoice.service.mapper.ClientMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    private ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.saveClient(clientDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.updateClient(clientDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

@PostMapping("/newsave")
    public ResponseEntity<ClientDTO> newSaveClient(@RequestBody ClientDTO clientDTO) {
       return ResponseEntity.ok(clientMapper.entityToDto(clientService.newSaveClient(clientMapper.dtoToEntity(clientDTO))));
    }
}
