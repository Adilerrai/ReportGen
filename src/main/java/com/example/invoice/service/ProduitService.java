package com.example.invoice.service;

import com.example.invoice.dto.ProduitDTO;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public interface ProduitService {
     List<ProduitDTO> getAllProduits();
     ProduitDTO getProduitById(Long id);
     ProduitDTO saveProduit(ProduitDTO produitDTO);
 void deleteProduit(Long id);
     ProduitDTO updateProduit(ProduitDTO produitDTO);



}
