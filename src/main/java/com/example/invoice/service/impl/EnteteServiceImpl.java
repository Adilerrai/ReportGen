package com.example.invoice.service.impl;

import com.example.invoice.dto.EnteteFactDTO;
import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.DetFacture;
import com.example.invoice.model.EnteteFact;
import com.example.invoice.repository.DetFactureRepository;
import com.example.invoice.repository.EnteteCriteriaRepo;
import com.example.invoice.repository.EnteteRepository;
import com.example.invoice.service.EnteteService;
import com.example.invoice.service.mapper.EnteteMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


import java.time.LocalDate;
import java.util.Date;

import static java.time.LocalDate.now;


@Service
public class EnteteServiceImpl implements EnteteService {




;



    private EnteteRepository enteteRepository;

    private EnteteMapper enteteMapper;

    private EnteteCriteriaRepo enteteCriteriaRepo;

    private DetFactureRepository detFactureRepository;



    public EnteteServiceImpl(EnteteRepository enteteRepository, DetFactureRepository detFactureRepository, EnteteMapper enteteMapper, EnteteCriteriaRepo enteteCriteriaRepo) {
        this.enteteRepository = enteteRepository;
        this.enteteMapper = enteteMapper;
        this.enteteCriteriaRepo = enteteCriteriaRepo;
        this.detFactureRepository = detFactureRepository;
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


        EnteteFact enteteFact = enteteMapper.dtoToEntity (enteteDTO);
        enteteFact.setCreatedDate(java.sql.Date.valueOf(now()));

        for (DetFacture detFacture : enteteFact.getDetFactures()) {
            detFactureRepository.save(detFacture);
        }

        enteteFact = enteteRepository.save(enteteFact);

        return   enteteMapper.entityToDto(enteteFact);
    }




    @Override
    public void deleteEntete(Long id) {
        enteteRepository.deleteById(id);
    }





    @Override
    public EnteteFactDTO updateEntete(EnteteFactDTO enteteDTO) {
        EnteteFact enteteFact = enteteRepository.findById(enteteDTO.getId()).get();
        if(enteteFact == null) {
                throw new RuntimeException("EnteteFact not found");
        }
        enteteFact.setClient(enteteDTO.getClient());
        enteteFact.setNumeroFacture(enteteDTO.getNumeroFacture());
        enteteFact.setDateFacture(enteteDTO.getDateFacture());
        enteteFact.setModePaiement(enteteDTO.getModePaiement());
        enteteFact.setStatut(enteteDTO.getStatut());
        enteteFact.setDetFactures(enteteDTO.getDetFactures());
        enteteRepository.save(enteteFact);
        return enteteMapper.entityToDto(enteteFact);
    }

    @Override
    public Page<EnteteFact> searchEnteteByCriteria(EnteteRechercheDTO enteteFactDTO , Pageable pageable ) {
        return  enteteCriteriaRepo.findByCriteria(enteteFactDTO , pageable);
    }

    @Override
    public Page<EnteteFact> searchEnteteByCriteriaHaving(EnteteRechercheDTO enteteFactDTO, Pageable pageable) {
        return enteteCriteriaRepo.findByCriteriaHaving(enteteFactDTO, pageable);
    }

    @Override
    public EnteteFact findEnteteById(Long id) {
        return null;
    }
}
