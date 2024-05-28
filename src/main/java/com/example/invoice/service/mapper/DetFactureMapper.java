package com.example.invoice.service.mapper;


import com.example.invoice.dto.DetFactureDTO;
import com.example.invoice.model.DetFacture;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ProduitMapper.class})
public interface DetFactureMapper {

        DetFactureDTO entityToDto(DetFacture detFacture);
        @InheritInverseConfiguration

        DetFacture dtoToEntity(DetFactureDTO detFactureDTO);

}
