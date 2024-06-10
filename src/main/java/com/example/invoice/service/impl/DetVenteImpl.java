package com.example.invoice.service.impl;

import com.example.invoice.dto.DetVenteDTO;
import com.example.invoice.dto.ProduitDTO;
import com.example.invoice.model.DetVente;
import com.example.invoice.model.Produit;
import com.example.invoice.repository.DetVenteRepository;
import com.example.invoice.service.DetFactService;
import com.example.invoice.service.ProduitService;
import com.example.invoice.service.mapper.DetVenteMapper;
import com.example.invoice.service.mapper.ProduitMapperImpl;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class DetVenteImpl implements DetFactService {

    private final DetVenteRepository DetVenteRepository;

    private final DetVenteMapper DetVenteMapper;


    private final ProduitServiceImpl produitService;
    private final ProduitMapperImpl produitMapperImpl;


    public DetVenteImpl(DetVenteRepository DetVenteRepository, DetVenteMapper   DetVenteMapper, ProduitServiceImpl produitService, ProduitMapperImpl produitMapperImpl)   {
        this.DetVenteRepository = DetVenteRepository;
        this.DetVenteMapper = DetVenteMapper;
        this.produitService = produitService;
        this.produitMapperImpl = produitMapperImpl;
    }




    @Override
    public List<DetVenteDTO> getAllDetFacts() {
        List<DetVente> DetVentes = DetVenteRepository.findAll();
        List<DetVenteDTO> DetVenteDTOS = DetVentes.stream().map(DetVente -> DetVenteMapper.entityToDto(DetVente)).toList();
        return DetVenteDTOS;
    }



    @Override
    public DetVenteDTO getDetFactById(Long id) {
        DetVente DetVente = DetVenteRepository.findById(id).get();
        return DetVenteMapper.entityToDto(DetVente);
    }




    @Override
    public DetVenteDTO saveDetFact(DetVenteDTO detFactDTO) {

        System.out.println(detFactDTO.getProduit().getId());
        System.out.println(produitService.getProduitById(detFactDTO.getProduit().getId()).getQuantite() + " " + detFactDTO.getQuantite());
        System.out.println(detFactDTO.getQuantite());


        System.out.println(detFactDTO.getProduit().getQuantite() + " " + detFactDTO.getQuantite());


        if(produitService.getProduitById(detFactDTO.getProduit().getId()).getQuantite() < detFactDTO.getQuantite()) {
            throw new RuntimeException("Quantité insuffisante");
        }

        Produit produitFromDb = produitService.getProduitById(detFactDTO.getProduit().getId());
        ProduitDTO produitDTO = produitMapperImpl.entityToDto(produitFromDb);
        produitFromDb.setQuantite((int) (produitFromDb.getQuantite()- detFactDTO.getQuantite()));
        produitService.updateProduit(produitDTO);
        DetVente DetVente = DetVenteMapper.dtoToEntity(detFactDTO);
        DetVenteRepository.save(DetVente);
        return DetVenteMapper.entityToDto(DetVente);
    }



    @Override
    public void deleteDetFact(Long id) {
        DetVenteRepository.deleteById(id);

    }

    @Override
    public DetVenteDTO updateDetFact(DetVenteDTO detFactDTO) {
        DetVente DetVente = DetVenteRepository.findById(detFactDTO.getId()).get();
        if(DetVente != null) {
            DetVente.setProduit(detFactDTO.getProduit());
            DetVente.setQuantite(detFactDTO.getQuantite());
            DetVente.setPrixUnitaire(detFactDTO.getPrixUnitaire());
            DetVente.setMontantTotalParProduit(detFactDTO.getMontantTotalParProduit());
            DetVente.setEnteteVente(detFactDTO.getEnteteVenteDTO());
            DetVenteRepository.save(DetVente);
            return DetVenteMapper.entityToDto(DetVente);
    }
        return null;
    }
}
