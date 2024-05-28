package com.example.invoice.service.mapper;

import com.example.invoice.dto.ProduitDTO;
import com.example.invoice.model.Produit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface ProduitMapper {

            ProduitDTO entityToDto(Produit produit);

    @InheritInverseConfiguration
            Produit dtoToEntity(ProduitDTO produitDTO);
}
