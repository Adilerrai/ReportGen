package com.example.invoice.service.mapper;

import com.example.invoice.dto.ProduitDTO;
import com.example.invoice.model.Produit;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-28T15:14:15+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ProduitMapperImpl implements ProduitMapper {

    @Override
    public ProduitDTO entityToDto(Produit produit) {
        if ( produit == null ) {
            return null;
        }

        ProduitDTO produitDTO = new ProduitDTO();

        produitDTO.setDesignation( produit.getDesignation() );
        produitDTO.setPrixUnitaire( produit.getPrixUnitaire() );
        produitDTO.setDescription( produit.getDescription() );
        produitDTO.setId( produit.getId() );

        return produitDTO;
    }

    @Override
    public Produit dtoToEntity(ProduitDTO produitDTO) {
        if ( produitDTO == null ) {
            return null;
        }

        Produit produit = new Produit();

        produit.setDesignation( produitDTO.getDesignation() );
        produit.setPrixUnitaire( produitDTO.getPrixUnitaire() );
        produit.setDescription( produitDTO.getDescription() );
        produit.setId( produitDTO.getId() );

        return produit;
    }
}
