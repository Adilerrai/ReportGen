package com.example.invoice.service.mapper;

import com.example.invoice.dto.FournisseurDTO;
import com.example.invoice.model.Fournisseur;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface FournisseurMapper {

    FournisseurDTO entityToDto(Fournisseur fournisseur);

    @InheritInverseConfiguration
    Fournisseur dtoToEntity(FournisseurDTO fournisseurDTO);
}
