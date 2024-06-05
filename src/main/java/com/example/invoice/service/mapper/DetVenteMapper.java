package com.example.invoice.service.mapper;


import com.example.invoice.dto.DetVenteDTO;
import com.example.invoice.model.DetVente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ProduitMapper.class})
public interface DetVenteMapper {

        DetVenteDTO entityToDto(DetVente DetVente);
        @InheritInverseConfiguration

        DetVente dtoToEntity(DetVenteDTO DetVenteDTO);

}
