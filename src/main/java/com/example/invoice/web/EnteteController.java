package com.example.invoice.web;


import com.example.invoice.dto.EnteteVenteDTO;
import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.EnteteVente;
import com.example.invoice.service.EnteteService;
import com.example.invoice.fileGeneration.ReportService;
import com.example.invoice.service.mapper.EnteteMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entetes-vente")
public class EnteteController {
    private EnteteService enteteService;
    private ReportService reportService;
    private EnteteMapper enteteMapper;



    public EnteteController(EnteteService enteteService, ReportService reportService , EnteteMapper enteteMapper){
        this.enteteService = enteteService;
        this.reportService = reportService;
        this.enteteMapper = enteteMapper;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<EnteteVenteDTO> addEntete(@RequestBody EnteteVenteDTO enteteDTO) {
        return ResponseEntity.ok(enteteService.saveEntete(enteteDTO));
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<EnteteVenteDTO> updateEntete(@RequestBody EnteteVenteDTO enteteDTO) {
        return ResponseEntity.ok(enteteService.updateEntete(enteteDTO));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<EnteteVenteDTO>> getAllEntetes() {
        return ResponseEntity.ok(enteteService.getAllEntetes());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<EnteteVenteDTO> getEnteteById(@PathVariable Long id) {
        return ResponseEntity.ok(enteteService.getEnteteById(id));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteEntete(@PathVariable Long id) {
        enteteService.deleteEntete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/reports/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> generateReport(@PathVariable Long id) {
        return ResponseEntity.ok().body(reportService.generateEntete(id));
    }


    @PostMapping("/multiple-search")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Page<EnteteVenteDTO>> searchMultiple(@RequestBody EnteteRechercheDTO EnteteVenteDTO, Pageable pageable) {
        Page<EnteteVente> EnteteVentes = enteteService.searchEnteteByCriteria (EnteteVenteDTO, pageable);
        Page<EnteteVenteDTO> EnteteVenteDTOS = EnteteVentes.map(enteteMapper::entityToDto);
        return ResponseEntity.ok(EnteteVenteDTOS);
    }

    @PostMapping("/multiple-search-having")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Page<EnteteVenteDTO>> searchMultipleHaving(@RequestBody EnteteRechercheDTO EnteteVenteDTO, Pageable pageable) {
        Page<EnteteVente> EnteteVentes = enteteService.searchEnteteByCriteriaHaving (EnteteVenteDTO, pageable);
        Page<EnteteVenteDTO> EnteteVenteDTOS = EnteteVentes.map(enteteMapper::entityToDto);
        return ResponseEntity.ok(EnteteVenteDTOS);
    }



}
