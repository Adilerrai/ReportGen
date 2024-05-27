package com.example.invoice.service.mapper;

import com.example.invoice.dto.EnteteFactDTO;
import com.example.invoice.model.EnteteFact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {   })
public interface EnteteMapper {
        public abstract EnteteFactDTO entityToDto(EnteteFact entete);
        public abstract EnteteFact dtoToEntity(EnteteFactDTO enteteDTO);
}
