package com.example.invoice.web;


import com.example.invoice.dto.ProduitDTO;
import com.example.invoice.service.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/produits")
public class ProduitController {


    private ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    public ResponseEntity<ProduitDTO> addProduit(@RequestBody ProduitDTO produitDTO) {
        return ResponseEntity.ok(produitService.saveProduit(produitDTO));
    }

    @PostMapping("/saveliste")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ProduitDTO>> saveListproduit(@RequestBody List<ProduitDTO> produitDTOS){
        List<ProduitDTO> prodList = produitDTOS.stream().map(produitDTO ->produitService.saveProduit((produitDTO))).toList();
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
        return ResponseEntity.ok(produitService.getAllProduits());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    public ResponseEntity<ProduitDTO> getProduitById(@PathVariable Long id) {
        return ResponseEntity.ok(produitService.getProduitById(id));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.ok().build();
    }

}
