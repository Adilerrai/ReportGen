package com.example.invoice.service.mapper;

import com.example.invoice.dto.EnteteVenteDTO;
import com.example.invoice.model.EnteteVente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {  DetVenteMapper.class, ClientMapper.class })
public interface EnteteMapper {


         EnteteVenteDTO entityToDto(EnteteVente entete);

         @InheritInverseConfiguration
         EnteteVente dtoToEntity(EnteteVenteDTO enteteDTO);
}
