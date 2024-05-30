package com.example.invoice.service.mapper;

import com.example.invoice.dto.ArreteDeCaisseDTO;
import com.example.invoice.model.ArreteDeCaisse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public interface ArreteDeCaisseMapper {

    ArreteDeCaisseDTO entityToDto(ArreteDeCaisse arreteDeCaisse);
    @InheritInverseConfiguration

    ArreteDeCaisse dtoToEntity(ArreteDeCaisseDTO arreteDeCaisseDTO);
}
