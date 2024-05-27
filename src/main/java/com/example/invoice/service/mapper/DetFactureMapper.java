package com.example.invoice.service.mapper;


import com.example.invoice.dto.DetFactureDTO;
import com.example.invoice.model.DetFacture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface DetFactureMapper {

    public abstract DetFactureDTO entityToDto(DetFacture detFacture);
    public abstract DetFacture dtoToEntity(DetFactureDTO detFactureDTO);

}
