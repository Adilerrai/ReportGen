package com.example.invoice.service.mapper;

import com.example.invoice.dto.DetAchatDTO;
import com.example.invoice.dto.ProduitDTO;
import com.example.invoice.model.DetAchat;
import com.example.invoice.model.Produit;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-30T16:15:21+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class DetAchatMapperImpl implements DetAchatMapper {

    @Override
    public DetAchatDTO toDto(DetAchat detAchat) {
        if ( detAchat == null ) {
            return null;
        }

        DetAchatDTO detAchatDTO = new DetAchatDTO();

        detAchatDTO.setId( detAchat.getId() );
        detAchatDTO.setProduit( produitToProduitDTO( detAchat.getProduit() ) );
        detAchatDTO.setQuantiteAchete( detAchat.getQuantiteAchete() );
        detAchatDTO.setPrixUnitaire( detAchat.getPrixUnitaire() );

        return detAchatDTO;
    }

    @Override
    public DetAchat toEntity(DetAchatDTO detAchatDTO) {
        if ( detAchatDTO == null ) {
            return null;
        }

        DetAchat detAchat = new DetAchat();

        detAchat.setId( detAchatDTO.getId() );
        detAchat.setQuantiteAchete( detAchatDTO.getQuantiteAchete() );
        detAchat.setProduit( produitDTOToProduit( detAchatDTO.getProduit() ) );
        detAchat.setPrixUnitaire( detAchatDTO.getPrixUnitaire() );

        return detAchat;
    }

    protected ProduitDTO produitToProduitDTO(Produit produit) {
        if ( produit == null ) {
            return null;
        }

        ProduitDTO produitDTO = new ProduitDTO();

        produitDTO.setQuantite( produit.getQuantite() );
        produitDTO.setDesignation( produit.getDesignation() );
        produitDTO.setPrixUnitaire( produit.getPrixUnitaire() );
        produitDTO.setDescription( produit.getDescription() );
        produitDTO.setId( produit.getId() );

        return produitDTO;
    }

    protected Produit produitDTOToProduit(ProduitDTO produitDTO) {
        if ( produitDTO == null ) {
            return null;
        }

        Produit produit = new Produit();

        produit.setQuantite( produitDTO.getQuantite() );
        produit.setDesignation( produitDTO.getDesignation() );
        produit.setPrixUnitaire( produitDTO.getPrixUnitaire() );
        produit.setDescription( produitDTO.getDescription() );
        produit.setId( produitDTO.getId() );

        return produit;
    }
}
