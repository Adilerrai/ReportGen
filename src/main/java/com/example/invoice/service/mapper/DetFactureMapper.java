package com.example.invoice.service.mapper;


import com.example.invoice.dto.DetFactureDTO;
import com.example.invoice.model.DetFacture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface DetFactureMapper {

        DetFactureDTO entityToDto(DetFacture detFacture);
        DetFacture dtoToEntity(DetFactureDTO detFactureDTO);

}
