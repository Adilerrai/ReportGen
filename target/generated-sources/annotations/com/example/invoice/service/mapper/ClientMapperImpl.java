package com.example.invoice.service.mapper;

import com.example.invoice.dto.ClientDTO;
import com.example.invoice.model.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-30T16:15:21+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDTO entityToDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId( client.getId() );
        clientDTO.setNom( client.getNom() );
        clientDTO.setPrenom( client.getPrenom() );
        clientDTO.setAdresse( client.getAdresse() );
        clientDTO.setEmail( client.getEmail() );
        clientDTO.setTelephone( client.getTelephone() );

        return clientDTO;
    }

    @Override
    public Client dtoToEntity(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDTO.getId() );
        client.setNom( clientDTO.getNom() );
        client.setPrenom( clientDTO.getPrenom() );
        client.setAdresse( clientDTO.getAdresse() );
        client.setEmail( clientDTO.getEmail() );
        client.setTelephone( clientDTO.getTelephone() );

        return client;
    }
}
