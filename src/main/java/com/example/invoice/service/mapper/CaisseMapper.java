package com.example.invoice.service.mapper;


import com.example.invoice.dto.CaisseDTO;
import com.example.invoice.model.Caisse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CaisseMapper {

         CaisseDTO entityToDto(Caisse caisse);


         @InheritInverseConfiguration
        Caisse dtoToEntity(CaisseDTO caisseDTO);
}
