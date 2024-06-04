package com.example.invoice.service.mapper;

import com.example.invoice.model.Client;
import com.example.invoice.dto.ClientDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public abstract class ClientMapper {

    public abstract ClientDTO entityToDto(Client client);

    @InheritInverseConfiguration
    public abstract Client dtoToEntity(ClientDTO clientDTO);
}
