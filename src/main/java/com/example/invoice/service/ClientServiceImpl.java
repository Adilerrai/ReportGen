package com.example.invoice.service;

import com.example.invoice.dto.ClientDTO;
import com.example.invoice.model.Client;
import com.example.invoice.repository.ClientRepository;
import com.example.invoice.service.mapper.ClientMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

@Transactional
public class ClientServiceImpl implements ClientService  {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    public ClientServiceImpl(ClientMapper clientMapper, ClientRepository clientRepository) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
    }

//    @Override
    public List<Client> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    public Client getClientById(Long id) {
        Client client = clientRepository.findById(id).get();
        return client;
    }

    public ClientDTO saveClient(ClientDTO clientDTO) {

        Client client = clientMapper.dtoToEntity(clientDTO);
        clientRepository.save(client);
        return clientMapper.entityToDto(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }

    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = clientRepository.findById(clientDTO.getId()).get();
        if(client != null) {
            client.setNom(clientDTO.getNom());
            client.setPrenom(clientDTO.getPrenom());
            client.setAdresse(clientDTO.getAdresse());
            client.setTelephone(clientDTO.getTelephone());
            client.setEmail(clientDTO.getEmail());
            clientRepository.save(client);
            return clientMapper.entityToDto(client);
        }
            return null;
        }

    public Client newSaveClient(Client client) {
       return  clientRepository.save(client);
    }
}


