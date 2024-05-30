package com.example.invoice.service.mapper;

import com.example.invoice.dto.EnteteFactDTO;
import com.example.invoice.model.DetFacture;
import com.example.invoice.model.EnteteFact;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-30T13:47:34+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class EnteteMapperImpl implements EnteteMapper {

    @Override
    public EnteteFactDTO entityToDto(EnteteFact entete) {
        if ( entete == null ) {
            return null;
        }

        EnteteFactDTO enteteFactDTO = new EnteteFactDTO();

        enteteFactDTO.setNumeroFacture( entete.getNumeroFacture() );
        enteteFactDTO.setDateFacture( entete.getDateFacture() );
        enteteFactDTO.setModePaiement( entete.getModePaiement() );
        enteteFactDTO.setCreatedDate( entete.getCreatedDate() );
        enteteFactDTO.setStatut( entete.getStatut() );
        enteteFactDTO.setClient( entete.getClient() );
        List<DetFacture> list = entete.getDetFactures();
        if ( list != null ) {
            enteteFactDTO.setDetFactures( new ArrayList<DetFacture>( list ) );
        }
        enteteFactDTO.setId( entete.getId() );
        enteteFactDTO.setTotalFacture( entete.getTotalFacture() );

        return enteteFactDTO;
    }

    @Override
    public EnteteFact dtoToEntity(EnteteFactDTO enteteDTO) {
        if ( enteteDTO == null ) {
            return null;
        }

        EnteteFact enteteFact = new EnteteFact();

        enteteFact.setTotalFacture( enteteDTO.getTotalFacture() );
        if ( enteteDTO.getCreatedDate() != null ) {
            enteteFact.setCreatedDate( new Timestamp( enteteDTO.getCreatedDate().getTime() ) );
        }
        enteteFact.setNumeroFacture( enteteDTO.getNumeroFacture() );
        enteteFact.setDateFacture( enteteDTO.getDateFacture() );
        enteteFact.setModePaiement( enteteDTO.getModePaiement() );
        enteteFact.setStatut( enteteDTO.getStatut() );
        enteteFact.setClient( enteteDTO.getClient() );
        List<DetFacture> list = enteteDTO.getDetFactures();
        if ( list != null ) {
            enteteFact.setDetFactures( new ArrayList<DetFacture>( list ) );
        }
        enteteFact.setId( enteteDTO.getId() );

        return enteteFact;
    }
}
