package com.example.invoice.service.mapper;

import com.example.invoice.dto.ProduitDTO;
import com.example.invoice.model.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProduitMapper {
            ProduitDTO entityToDto(Produit produit);
            Produit dtoToEntity(ProduitDTO produitDTO);
}
