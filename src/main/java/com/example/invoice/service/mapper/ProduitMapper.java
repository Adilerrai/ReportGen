package com.example.invoice.service.mapper;

import com.example.invoice.dto.ProduitDTO;
import com.example.invoice.model.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProduitMapper {
    public abstract ProduitDTO entityToDto(Produit produit);
    public abstract Produit dtoToEntity(ProduitDTO produitDTO);

}
