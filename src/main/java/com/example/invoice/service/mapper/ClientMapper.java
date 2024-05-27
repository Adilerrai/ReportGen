package com.example.invoice.service.mapper;

import com.example.invoice.model.Client;
import com.example.invoice.dto.ClientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ClientMapper {
          ClientDTO entityToDto(Client client);
          Client dtoToEntity(ClientDTO clientDTO);
}
