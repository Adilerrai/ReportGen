package com.example.invoice.service.impl;

import com.example.invoice.dto.ProduitDTO;
import com.example.invoice.model.Produit;
import com.example.invoice.repository.ProduitRepository;
import com.example.invoice.service.ProduitService;
import com.example.invoice.service.mapper.ProduitMapper;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProduitServiceImpl  implements ProduitService {
    private ProduitMapper produitMapper;
    private ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitMapper produitMapper, ProduitRepository produitRepository) {
        this.produitMapper = produitMapper;
        this.produitRepository = produitRepository;
    }

    @Override
    public List<ProduitDTO> getAllProduits() {
        List<Produit> produits = produitRepository.findAll();
        List<ProduitDTO> produitDTOS = produits.stream().map(produit -> produitMapper.entityToDto(produit)).toList();
        return produitDTOS;
    }

    @Override
    public ProduitDTO getProduitById(Long id) {
        Produit produit = produitRepository.findById(id).get();
        return produitMapper.entityToDto(produit);

    }

    @Override
    public ProduitDTO saveProduit(ProduitDTO produitDTO) {
        Produit produit = produitMapper.dtoToEntity(produitDTO);
        produitRepository.save(produit);
        return produitMapper.entityToDto(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);

    }

    @Override
    public ProduitDTO updateProduit(ProduitDTO produitDTO) {
        Produit produit = produitRepository.findById(produitDTO.getId()).get();
        if(produit != null) {
            produit.setDesignation(produitDTO.getDesignation());
            produit.setPrixUnitaire(produitDTO.getPrixUnitaire());
            produit.setQuantite(produitDTO.getQuantite());
            produit.setDescription(produitDTO.getDescription());
            produitRepository.save(produit);
            return produitMapper.entityToDto(produit);
        }
        return null;
    }
}
