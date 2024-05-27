package com.example.invoice.service;

import com.example.invoice.dto.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ClientService {
    public List<ClientDTO> getAllClients();
    public ClientDTO getClientById(Long id);
    public ClientDTO saveClient(ClientDTO clientDTO);
    public void deleteClient(Long id);
    public ClientDTO updateClient(ClientDTO clientDTO);



}
