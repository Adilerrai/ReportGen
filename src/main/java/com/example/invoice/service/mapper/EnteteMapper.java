package com.example.invoice.service.mapper;

import com.example.invoice.dto.EnteteFactDTO;
import com.example.invoice.model.EnteteFact;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {  DetFactureMapper.class, ClientMapper.class })
public interface EnteteMapper {


         EnteteFactDTO entityToDto(EnteteFact entete);

         @InheritInverseConfiguration
         EnteteFact dtoToEntity(EnteteFactDTO enteteDTO);
}
