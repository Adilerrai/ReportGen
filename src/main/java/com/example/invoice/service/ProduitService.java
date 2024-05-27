package com.example.invoice.service;

import com.example.invoice.dto.ProduitDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProduitService {
    public List<ProduitDTO> getAllProduits();
    public ProduitDTO getProduitById(Long id);
    public ProduitDTO saveProduit(ProduitDTO produitDTO);
    public void deleteProduit(Long id);
    public ProduitDTO updateProduit(ProduitDTO produitDTO);
}
