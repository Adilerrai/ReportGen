package com.example.invoice.service.impl;

import com.example.invoice.dto.EnteteFactDTO;
import com.example.invoice.model.EnteteFact;
import com.example.invoice.repository.EnteteRepository;
import com.example.invoice.service.EnteteService;
import com.example.invoice.service.mapper.EnteteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnteteServiceImpl implements EnteteService {

    private EnteteRepository enteteRepository;

    private EnteteMapper enteteMapper;

    public EnteteServiceImpl(EnteteRepository enteteRepository, EnteteMapper enteteMapper) {
        this.enteteRepository = enteteRepository;
        this.enteteMapper = enteteMapper;
    }


    @Override
    public List<EnteteFactDTO> getAllEntetes() {
        List<EnteteFact> EnteteFacts = enteteRepository.findAll();
        List<EnteteFactDTO> enteteFactDTOS = EnteteFacts.stream().map(enteteFact -> enteteMapper.entityToDto(enteteFact)).toList();
        return enteteFactDTOS;
    }

    @Override
    public EnteteFactDTO getEnteteById(Long id) {
        EnteteFact enteteFact = enteteRepository.findById(id).get();
        return enteteMapper.entityToDto(enteteFact);
    }

    @Override
    public EnteteFactDTO saveEntete(EnteteFactDTO enteteDTO) {
        EnteteFact enteteFact = enteteMapper.dtoToEntity(enteteDTO);
        enteteRepository.save(enteteFact);
        return enteteMapper.entityToDto(enteteFact);
    }

    @Override
    public void deleteEntete(Long id) {
        enteteRepository.deleteById(id);
    }

    @Override
    public EnteteFactDTO updateEntete(EnteteFactDTO enteteDTO) {
        EnteteFact enteteFact = enteteRepository.findById(enteteDTO.getId()).get();
        if(enteteFact != null) {
            enteteFact.setClient(enteteDTO.getClient());
            enteteFact.setNumeroFacture(enteteDTO.getNumeroFacture());
            enteteFact.setDateFacture(enteteDTO.getDateFacture());
            enteteFact.setModePaiement(enteteDTO.getModePaiement());
            enteteFact.setStatut(enteteDTO.getStatut());
            enteteFact.setDetFactures(enteteDTO.getDetFactures());
            enteteRepository.save(enteteFact);
            return enteteMapper.entityToDto(enteteFact);
        }
        return null;

    }
}
