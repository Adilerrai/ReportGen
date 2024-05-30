package com.example.invoice.service.impl;

import com.example.invoice.dto.DetFactureDTO;
import com.example.invoice.dto.ProduitDTO;
import com.example.invoice.model.DetFacture;
import com.example.invoice.repository.DetFactureRepository;
import com.example.invoice.service.DetFactService;
import com.example.invoice.service.ProduitService;
import com.example.invoice.service.mapper.DetFactureMapper;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class DetFactureImpl implements DetFactService {

    private final DetFactureRepository detFactureRepository;

    private final DetFactureMapper detFactureMapper;


    private final ProduitService produitService;


    public DetFactureImpl(DetFactureRepository detFactureRepository, DetFactureMapper   detFactureMapper, ProduitService produitService)   {
        this.detFactureRepository = detFactureRepository;
        this.detFactureMapper = detFactureMapper;
        this.produitService = produitService;
    }




    @Override
    public List<DetFactureDTO> getAllDetFacts() {
        List<DetFacture> detFactures = detFactureRepository.findAll();
        List<DetFactureDTO> detFactureDTOS = detFactures.stream().map(detFacture -> detFactureMapper.entityToDto(detFacture)).toList();
        return detFactureDTOS;
    }



    @Override
    public DetFactureDTO getDetFactById(Long id) {
        DetFacture detFacture = detFactureRepository.findById(id).get();
        return detFactureMapper.entityToDto(detFacture);
    }




    @Override
    public DetFactureDTO saveDetFact(DetFactureDTO detFactDTO) {

        System.out.println(detFactDTO.getProduit().getId());
        System.out.println(produitService.getProduitById(detFactDTO.getProduit().getId()).getQuantite() + " " + detFactDTO.getQuantite());
        System.out.println(detFactDTO.getQuantite());


        System.out.println(detFactDTO.getProduit().getQuantite() + " " + detFactDTO.getQuantite());


        if(produitService.getProduitById(detFactDTO.getProduit().getId()).getQuantite() < detFactDTO.getQuantite()) {
            throw new RuntimeException("Quantité insuffisante");
        }

        ProduitDTO produitFromDb = produitService.getProduitById(detFactDTO.getProduit().getId());
        produitFromDb.setQuantite((int) (produitFromDb.getQuantite()- detFactDTO.getQuantite()));
        produitService.updateProduit(produitFromDb);
        DetFacture detFacture = detFactureMapper.dtoToEntity(detFactDTO);
        detFactureRepository.save(detFacture);
        return detFactureMapper.entityToDto(detFacture);
    }



    @Override
    public void deleteDetFact(Long id) {
        detFactureRepository.deleteById(id);

    }

    @Override
    public DetFactureDTO updateDetFact(DetFactureDTO detFactDTO) {
        DetFacture detFacture = detFactureRepository.findById(detFactDTO.getId()).get();
        if(detFacture != null) {
            detFacture.setProduit(detFactDTO.getProduit());
            detFacture.setQuantite(detFactDTO.getQuantite());
            detFacture.setPrixUnitaire(detFactDTO.getPrixUnitaire());
            detFacture.setMontantTotalParProduit(detFactDTO.getMontantTotalParProduit());
            detFacture.setFacture(detFactDTO.getEnteteFactDTO());
            detFactureRepository.save(detFacture);
            return detFactureMapper.entityToDto(detFacture);
    }
        return null;
    }
}
