package com.example.invoice.web;


import com.example.invoice.dto.ProduitDTO;
import com.example.invoice.service.ProduitService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ProduitDTO> addProduit(@RequestBody ProduitDTO produitDTO) {
        return ResponseEntity.ok(produitService.saveProduit(produitDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<ProduitDTO> updateProduit(@RequestBody ProduitDTO produitDTO) {
        return ResponseEntity.ok(produitService.updateProduit(produitDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProduitDTO>> getAllProduits() {
        return ResponseEntity.ok(produitService.getAllProduits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDTO> getProduitById(@PathVariable Long id) {
        return ResponseEntity.ok(produitService.getProduitById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.ok().build();
    }

}
