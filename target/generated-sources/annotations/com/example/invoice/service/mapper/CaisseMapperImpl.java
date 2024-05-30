package com.example.invoice.service.mapper;

import com.example.invoice.dto.CaisseDTO;
import com.example.invoice.model.Caisse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-30T13:47:34+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class CaisseMapperImpl implements CaisseMapper {

    @Override
    public CaisseDTO entityToDto(Caisse caisse) {
        if ( caisse == null ) {
            return null;
        }

        CaisseDTO caisseDTO = new CaisseDTO();

        caisseDTO.setId( caisse.getId() );
        caisseDTO.setSoldeDeCaisse( caisse.getSoldeDeCaisse() );
        caisseDTO.setTotalAchats( caisse.getTotalAchats() );
        caisseDTO.setTotalDepenses( caisse.getTotalDepenses() );
        caisseDTO.setDifference( caisse.getDifference() );
        caisseDTO.setTotalVentes( caisse.getTotalVentes() );

        return caisseDTO;
    }

    @Override
    public Caisse dtoToEntity(CaisseDTO caisseDTO) {
        if ( caisseDTO == null ) {
            return null;
        }

        Caisse caisse = new Caisse();

        caisse.setId( caisseDTO.getId() );
        caisse.setSoldeDeCaisse( caisseDTO.getSoldeDeCaisse() );
        caisse.setTotalAchats( caisseDTO.getTotalAchats() );
        caisse.setTotalDepenses( caisseDTO.getTotalDepenses() );
        caisse.setDifference( caisseDTO.getDifference() );
        caisse.setTotalVentes( caisseDTO.getTotalVentes() );

        return caisse;
    }
}
