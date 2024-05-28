package com.example.invoice.service;

import com.example.invoice.dto.ClientDTO;
import com.example.invoice.model.Client;

import java.util.List;




public interface ClientService {
     List<ClientDTO> getAllClients();

     ClientDTO getClientById(Long id);

     ClientDTO saveClient(ClientDTO clientDTO);


     void deleteClient(Long id);

     ClientDTO updateClient(ClientDTO clientDTO);

    Client newSaveClient(Client client);



}
