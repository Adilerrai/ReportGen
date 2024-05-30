package com.example.invoice.web;


import com.example.invoice.dto.FournisseurDTO;
import com.example.invoice.model.Fournisseur;
import com.example.invoice.service.FournisseurService;
import com.example.invoice.service.mapper.FournisseurMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurController {

    private final FournisseurService fournisseurService;

    private final FournisseurMapper fournisseurMapper;


    public FournisseurController(FournisseurService fournisseurService, FournisseurMapper fournisseurMapper) {
        this.fournisseurService = fournisseurService;
        this.fournisseurMapper = fournisseurMapper;
    }

    @PostMapping("/nouveau-fournisseur")
    public ResponseEntity<FournisseurDTO> createFournisseur(@RequestBody FournisseurDTO fournisseurDTO) {
        Fournisseur fournisseur = fournisseurMapper.dtoToEntity(fournisseurDTO);
        Fournisseur fournisseur1 = fournisseurService.createFournisseur(fournisseur);
        return ResponseEntity.ok(fournisseurMapper.entityToDto(fournisseur1));
    }

    @PostMapping("/modifier-fournisseur")
    public ResponseEntity<FournisseurDTO> updateFournisseur(@RequestBody  FournisseurDTO fournisseurDTO) {
        Fournisseur fournisseur = fournisseurMapper.dtoToEntity(fournisseurDTO);
        Fournisseur fournisseur1 = fournisseurService.updateFournisseur(fournisseur);
        return ResponseEntity.ok(fournisseurMapper.entityToDto(fournisseur1));
    }


    @DeleteMapping("/supprimer-fournisseur/{id}")
    public ResponseEntity<Void> deleteFournisseur( @PathVariable Long id) {
        fournisseurService.deleteFournisseur(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-fournisseur-by-achat-id/{id}")
    public ResponseEntity<FournisseurDTO> getFournisseur(@PathVariable Long id) {
        Fournisseur fournisseur = fournisseurService.getFournisseurByAchatId(id);
        return ResponseEntity.ok(fournisseurMapper.entityToDto(fournisseur));
    }

    @GetMapping("/get-fournisseur-by-id/{id}")
    public ResponseEntity<FournisseurDTO> getFournisseurById(@PathVariable Long id) {
        Fournisseur fournisseur = fournisseurService.getFournisseurById(id);
        return ResponseEntity.ok(fournisseurMapper.entityToDto(fournisseur));
    }




}
