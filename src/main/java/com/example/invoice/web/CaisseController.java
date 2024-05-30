package com.example.invoice.web;

import com.example.invoice.dto.CaisseDTO;
import com.example.invoice.model.Caisse;
import com.example.invoice.service.CaisseService;
import com.example.invoice.service.mapper.CaisseMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/caisse")
public class CaisseController {

    private final CaisseService caisseService;
    private final CaisseMapper caisseMapper;

    public CaisseController(CaisseService caisseService, CaisseMapper caisseMapper) {
        this.caisseService = caisseService;
        this.caisseMapper = caisseMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<CaisseDTO> createCaisse(@RequestBody CaisseDTO caisseDTO) {
        Caisse caisse = caisseMapper.dtoToEntity(caisseDTO);
        Caisse createdCaisse = caisseService.createCaisse(caisse);
        return ResponseEntity.ok(caisseMapper.entityToDto(createdCaisse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaisseDTO> getCaisse(@PathVariable Long id) {
        Caisse caisse = caisseService.getCaisse(id);
        return ResponseEntity.ok(caisseMapper.entityToDto(caisse));
    }

    @PutMapping("/update")
    public ResponseEntity<CaisseDTO> updateCaisse(@RequestBody CaisseDTO caisseDTO) {
        Caisse caisse = caisseMapper.dtoToEntity(caisseDTO);
        Caisse updatedCaisse = caisseService.update (caisse);
        return ResponseEntity.ok(caisseMapper.entityToDto(updatedCaisse));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCaisse(@PathVariable Long id) {
        caisseService.deleteCaisse(id);
        return ResponseEntity.ok().build();
    }
}
