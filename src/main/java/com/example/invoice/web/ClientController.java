package com.example.invoice.web;


import com.example.invoice.dto.ClientDTO;
import com.example.invoice.model.Client;
import com.example.invoice.service.ClientServiceImpl;
import com.example.invoice.service.mapper.ClientMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientServiceImpl clientService;

    private ClientMapper clientMapper;

    public ClientController(ClientServiceImpl clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper=clientMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.saveClient(clientDTO));
    }


    @PostMapping("/saveliste")

    public ResponseEntity<List<ClientDTO>> addClient(@RequestBody List<ClientDTO> clientDTOs) {

        List<ClientDTO> clientDTOList = clientDTOs.stream().map(clientDTO -> clientService.saveClient(clientDTO)).toList();

        return  ResponseEntity.ok(clientDTOList);
    }

    @PutMapping("/update")

    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.updateClient(clientDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<Client> clientList = clientService.getAllClients();
        List<ClientDTO> clientDTOS = clientList.stream().map(client -> clientMapper.entityToDto(client)).toList();
        return ResponseEntity.ok(clientDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        Client client= clientService.getClientById(id);
        ClientDTO clientDto = clientMapper.entityToDto(client);
        return ResponseEntity.ok(clientDto);
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
