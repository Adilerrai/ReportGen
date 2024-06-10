package com.example.invoice.web;


import com.example.invoice.dto.ProduitDTO;
import com.example.invoice.model.Produit;
import com.example.invoice.service.impl.ProduitServiceImpl;
import com.example.invoice.service.mapper.ProduitMapperImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/produits")
public class ProduitController {


    private final ProduitMapperImpl produitMapperImpl;
    private ProduitServiceImpl produitService;

    public ProduitController(ProduitServiceImpl produitService, ProduitMapperImpl produitMapperImpl) {
        this.produitService = produitService;
        this.produitMapperImpl = produitMapperImpl;
    }

    @PostMapping("/add")
    public ResponseEntity<Produit> addProduit(@RequestBody ProduitDTO produitDTO) {
        Produit produit = produitMapperImpl.dtoToEntity(produitDTO);
        Produit produit1 = produitService.saveProduit(produit);
        return ResponseEntity.ok(produit1);
    }

    @PostMapping("/saveliste")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ProduitDTO>> saveListproduit(@RequestBody List<ProduitDTO> produitDTOS){
        List<ProduitDTO> prodList = produitDTOS.stream()
                .map(produitDTO -> produitService.saveProduit(produitMapperImpl.dtoToEntity(produitDTO)))
                .map(produit -> produitMapperImpl.entityToDto(produit))
                .collect(Collectors.toList());
        return ResponseEntity.ok(prodList);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProduitDTO> updateProduit(@RequestBody ProduitDTO produitDTO) {
        return ResponseEntity.ok(produitService.updateProduit(produitDTO));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ProduitDTO>> getAllProduits() {
        List<Produit> produits = produitService.getAllProduits();
        List<ProduitDTO> produitDTOS = produits.stream()
                .map(produit -> produitMapperImpl.entityToDto(produit))
                .collect(Collectors.toList());
        return ResponseEntity.ok(produitDTOS);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProduitDTO> getProduitById(@PathVariable Long id) {
        Produit produit = produitService.getProduitById(id);
        ProduitDTO produitDTO = produitMapperImpl.entityToDto(produit);
        return ResponseEntity.ok(produitDTO);
    }



    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.ok().build();
    }

}
