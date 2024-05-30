package com.example.invoice.service.mapper;

import com.example.invoice.dto.AchatDTO;
import com.example.invoice.dto.DetAchatDTO;
import com.example.invoice.model.Achat;
import com.example.invoice.model.DetAchat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-30T13:47:34+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class AchatMapperImpl implements AchatMapper {

    @Autowired
    private FournisseurMapper fournisseurMapper;
    @Autowired
    private DetAchatMapper detAchatMapper;

    @Override
    public AchatDTO entityToDto(Achat achat) {
        if ( achat == null ) {
            return null;
        }

        AchatDTO achatDTO = new AchatDTO();

        achatDTO.setId( achat.getId() );
        achatDTO.setDateAchat( achat.getDateAchat() );
        achatDTO.setStatusAchat( achat.getStatusAchat() );
        achatDTO.setFournisseur( fournisseurMapper.entityToDto( achat.getFournisseur() ) );
        achatDTO.setDetAchats( detAchatListToDetAchatDTOList( achat.getDetAchats() ) );
        achatDTO.setTotalAchat( achat.getTotalAchat() );

        return achatDTO;
    }

    @Override
    public Achat dtoToEntity(AchatDTO achatDTO) {
        if ( achatDTO == null ) {
            return null;
        }

        Achat achat = new Achat();

        achat.setId( achatDTO.getId() );
        achat.setDetAchats( detAchatDTOListToDetAchatList( achatDTO.getDetAchats() ) );
        achat.setDateAchat( achatDTO.getDateAchat() );
        achat.setTotalAchat( achatDTO.getTotalAchat() );
        achat.setFournisseur( fournisseurMapper.dtoToEntity( achatDTO.getFournisseur() ) );
        achat.setStatusAchat( achatDTO.getStatusAchat() );

        return achat;
    }

    protected List<DetAchatDTO> detAchatListToDetAchatDTOList(List<DetAchat> list) {
        if ( list == null ) {
            return null;
        }

        List<DetAchatDTO> list1 = new ArrayList<DetAchatDTO>( list.size() );
        for ( DetAchat detAchat : list ) {
            list1.add( detAchatMapper.toDto( detAchat ) );
        }

        return list1;
    }

    protected List<DetAchat> detAchatDTOListToDetAchatList(List<DetAchatDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<DetAchat> list1 = new ArrayList<DetAchat>( list.size() );
        for ( DetAchatDTO detAchatDTO : list ) {
            list1.add( detAchatMapper.toEntity( detAchatDTO ) );
        }

        return list1;
    }
}
