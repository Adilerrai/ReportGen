package com.example.invoice.service.mapper;


import com.example.invoice.dto.AchatDTO;
import com.example.invoice.model.Achat;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = { FournisseurMapper.class , DetAchatMapper.class})
public interface AchatMapper {

    AchatDTO entityToDto(Achat achat);
    @InheritInverseConfiguration
    Achat dtoToEntity(AchatDTO achatDTO);

}
