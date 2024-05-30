package com.example.invoice.service.mapper;

import com.example.invoice.dto.FournisseurDTO;
import com.example.invoice.model.Fournisseur;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-30T13:47:34+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class FournisseurMapperImpl implements FournisseurMapper {

    @Override
    public FournisseurDTO entityToDto(Fournisseur fournisseur) {
        if ( fournisseur == null ) {
            return null;
        }

        FournisseurDTO fournisseurDTO = new FournisseurDTO();

        fournisseurDTO.setId( fournisseur.getId() );
        fournisseurDTO.setNom( fournisseur.getNom() );
        fournisseurDTO.setAdresse( fournisseur.getAdresse() );
        fournisseurDTO.setTelephone( fournisseur.getTelephone() );
        fournisseurDTO.setEmail( fournisseur.getEmail() );
        fournisseurDTO.setInfoSupplementaire( fournisseur.getInfoSupplementaire() );

        return fournisseurDTO;
    }

    @Override
    public Fournisseur dtoToEntity(FournisseurDTO fournisseurDTO) {
        if ( fournisseurDTO == null ) {
            return null;
        }

        Fournisseur fournisseur = new Fournisseur();

        fournisseur.setId( fournisseurDTO.getId() );
        fournisseur.setNom( fournisseurDTO.getNom() );
        fournisseur.setAdresse( fournisseurDTO.getAdresse() );
        fournisseur.setTelephone( fournisseurDTO.getTelephone() );
        fournisseur.setEmail( fournisseurDTO.getEmail() );
        fournisseur.setInfoSupplementaire( fournisseurDTO.getInfoSupplementaire() );

        return fournisseur;
    }
}
