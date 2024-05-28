package com.example.invoice.service.mapper;

import com.example.invoice.dto.DetFactureDTO;
import com.example.invoice.model.DetFacture;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-28T15:14:15+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class DetFactureMapperImpl implements DetFactureMapper {

    @Override
    public DetFactureDTO entityToDto(DetFacture detFacture) {
        if ( detFacture == null ) {
            return null;
        }

        DetFactureDTO detFactureDTO = new DetFactureDTO();

        detFactureDTO.setProduit( detFacture.getProduit() );
        detFactureDTO.setQuantite( detFacture.getQuantite() );
        detFactureDTO.setPrixUnitaire( detFacture.getPrixUnitaire() );
        detFactureDTO.setMontantTotalParProduit( detFacture.getMontantTotalParProduit() );
        detFactureDTO.setId( detFacture.getId() );

        return detFactureDTO;
    }

    @Override
    public DetFacture dtoToEntity(DetFactureDTO detFactureDTO) {
        if ( detFactureDTO == null ) {
            return null;
        }

        DetFacture detFacture = new DetFacture();

        detFacture.setId( detFactureDTO.getId() );
        detFacture.setQuantite( detFactureDTO.getQuantite() );
        detFacture.setPrixUnitaire( detFactureDTO.getPrixUnitaire() );
        detFacture.setProduit( detFactureDTO.getProduit() );
        detFacture.setMontantTotalParProduit( detFactureDTO.getMontantTotalParProduit() );

        return detFacture;
    }
}
