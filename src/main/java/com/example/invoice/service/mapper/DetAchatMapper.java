package com.example.invoice.service.mapper;


import com.example.invoice.dto.DetAchatDTO;
import com.example.invoice.model.DetAchat;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetAchatMapper {

    DetAchatDTO toDto(DetAchat detAchat);

    @InheritInverseConfiguration
    DetAchat toEntity(DetAchatDTO detAchatDTO);

    default DetAchat fromId(Long id) {
        if (id == null) {
            return null;
        }
        DetAchat detAchat = new DetAchat();
        detAchat.setId(id);
        return detAchat;
    }
}
