package com.example.invoice.service.impl;

import com.example.invoice.dto.EnteteVenteDTO;
import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.Caisse;
import com.example.invoice.model.DetVente;
import com.example.invoice.model.EnteteVente;
import com.example.invoice.model.Produit;
import com.example.invoice.repository.*;
import com.example.invoice.service.EnteteService;
import com.example.invoice.service.mapper.EnteteMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;


import static java.time.LocalDate.now;


@Service
public class EnteteServiceImpl implements EnteteService {


    private final ProduitRepository produitRepository;
    private EnteteRepository enteteRepository;

    private EnteteMapper enteteMapper;

    private EnteteCriteriaRepo enteteCriteriaRepo;

    private DetVenteRepository DetVenteRepository;

    private  final CaisseRepository caisseRepository;


    public EnteteServiceImpl(EnteteRepository enteteRepository, DetVenteRepository DetVenteRepository, EnteteMapper enteteMapper, EnteteCriteriaRepo enteteCriteriaRepo, CaisseRepository caisseRepository, ProduitRepository produitRepository) {
        this.enteteRepository = enteteRepository;
        this.enteteMapper = enteteMapper;
        this.enteteCriteriaRepo = enteteCriteriaRepo;
        this.DetVenteRepository = DetVenteRepository;
        this.caisseRepository = caisseRepository;
        this.produitRepository = produitRepository;
    }


    @Override
    public List<EnteteVenteDTO> getAllEntetes() {
        List<EnteteVente> EnteteVentes = enteteRepository.findAll();
        List<EnteteVenteDTO> EnteteVenteDTOS = EnteteVentes.stream().map(EnteteVente -> enteteMapper.entityToDto(EnteteVente)).toList();
        return EnteteVenteDTOS;
    }




    @Override
    public EnteteVenteDTO getEnteteById(Long id) {
        EnteteVente EnteteVente = enteteRepository.findById(id).get();
        return enteteMapper.entityToDto(EnteteVente);
    }



    @Override
    public EnteteVenteDTO saveEntete(EnteteVenteDTO enteteDTO) {



        EnteteVente EnteteVente = enteteMapper.dtoToEntity (enteteDTO);


        java.util.Date date = java.util.Date.from(now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        EnteteVente.setDateFacture(new java.sql.Timestamp(date.getTime()));

        for (DetVente detVente : EnteteVente.getDetVentes()) {
            Optional<Produit> produitFromDb = produitRepository.findById(detVente.getProduit().getId());
            BigDecimal unitPrice = produitFromDb.get().getPrixUnitaire();
            int promotion = detVente.getPromotion();

            if (promotion != 0){
                BigDecimal discount = unitPrice.multiply(BigDecimal.valueOf(promotion)).divide(BigDecimal.valueOf(100));
                unitPrice = unitPrice.subtract(discount);
            }

            detVente.setPrixUnitaire(unitPrice);
            DetVenteRepository.save(detVente);
        }

        BigDecimal totalAmount = enteteDTO.getDetVentes().stream()
                .filter(DetVente -> DetVente.getMontantTotalParProduit() != null)
                .map(DetVente -> DetVente.getMontantTotalParProduit())
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        Caisse caisse = caisseRepository.findById(1L).get();
        caisse.setTotalVentes(caisse.getTotalVentes().add(totalAmount));

        System.out.println("caisse.getTotalVentes() " + caisse.getTotalVentes()) ;

        caisse.setDifference(caisse.getTotalVentes().subtract(caisse.getTotalEnteteAchats()));

        EnteteVente.setTotalFacture(totalAmount);
        EnteteVente = enteteRepository.save(EnteteVente);

        return   enteteMapper.entityToDto(EnteteVente);
    }




    @Override
    public void deleteEntete(Long id) {
        enteteRepository.deleteById(id);
    }





    @Override
    public EnteteVenteDTO updateEntete(EnteteVenteDTO enteteDTO) {
        EnteteVente EnteteVente = enteteRepository.findById(enteteDTO.getId()).get();
        if(EnteteVente == null) {
                throw new RuntimeException("EnteteVente not found");
        }
        EnteteVente.setClient(enteteDTO.getClient());
        EnteteVente.setNumeroFacture(enteteDTO.getNumeroFacture());
        EnteteVente.setDateFacture(enteteDTO.getDateFacture());
        EnteteVente.setModePaiement(enteteDTO.getModePaiement());
        EnteteVente.setStatut(enteteDTO.getStatut());
        EnteteVente.setDetVentes(enteteDTO.getDetVentes());
        enteteRepository.save(EnteteVente);
        return enteteMapper.entityToDto(EnteteVente);
    }

    @Override
    public Page<EnteteVente> searchEnteteByCriteria(EnteteRechercheDTO EnteteVenteDTO , Pageable pageable ) {
        return  enteteCriteriaRepo.findByCriteria(EnteteVenteDTO , pageable);
    }

    @Override
    public Page<EnteteVente> searchEnteteByCriteriaHaving(EnteteRechercheDTO EnteteVenteDTO, Pageable pageable) {
        return enteteCriteriaRepo.findByCriteriaHaving(EnteteVenteDTO, pageable);
    }

    @Override
    public EnteteVente findEnteteById(Long id) {
        return null;
    }
}
