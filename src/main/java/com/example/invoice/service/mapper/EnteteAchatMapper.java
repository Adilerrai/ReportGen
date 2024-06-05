package com.example.invoice.service.mapper;


import com.example.invoice.dto.EnteteAchatDTO;
import com.example.invoice.model.EnteteAchat;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = { FournisseurMapper.class , DetAchatMapper.class})
public interface EnteteAchatMapper {

    EnteteAchatDTO entityToDto(EnteteAchat EnteteAchat);
    @InheritInverseConfiguration
    EnteteAchat dtoToEntity(EnteteAchatDTO EnteteAchatDTO);

}
