package com.example.invoice.service.mapper;

import com.example.invoice.dto.ArreteDeCaisseDTO;
import com.example.invoice.model.ArreteDeCaisse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-30T16:15:21+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ArreteDeCaisseMapperImpl implements ArreteDeCaisseMapper {

    @Override
    public ArreteDeCaisseDTO entityToDto(ArreteDeCaisse arreteDeCaisse) {
        if ( arreteDeCaisse == null ) {
            return null;
        }

        ArreteDeCaisseDTO arreteDeCaisseDTO = new ArreteDeCaisseDTO();

        arreteDeCaisseDTO.setTotalAchat( arreteDeCaisse.getTotalAchat() );
        arreteDeCaisseDTO.setTotalVente( arreteDeCaisse.getTotalVente() );
        arreteDeCaisseDTO.setTotalDepense( arreteDeCaisse.getTotalDepense() );
        arreteDeCaisseDTO.setTotalBenefice( arreteDeCaisse.getTotalBenefice() );
        arreteDeCaisseDTO.setId( arreteDeCaisse.getId() );

        return arreteDeCaisseDTO;
    }

    @Override
    public ArreteDeCaisse dtoToEntity(ArreteDeCaisseDTO arreteDeCaisseDTO) {
        if ( arreteDeCaisseDTO == null ) {
            return null;
        }

        ArreteDeCaisse arreteDeCaisse = new ArreteDeCaisse();

        arreteDeCaisse.setTotalAchat( arreteDeCaisseDTO.getTotalAchat() );
        arreteDeCaisse.setTotalVente( arreteDeCaisseDTO.getTotalVente() );
        arreteDeCaisse.setTotalDepense( arreteDeCaisseDTO.getTotalDepense() );
        arreteDeCaisse.setTotalBenefice( arreteDeCaisseDTO.getTotalBenefice() );
        arreteDeCaisse.setId( arreteDeCaisseDTO.getId() );

        return arreteDeCaisse;
    }
}
