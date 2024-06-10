package com.example.invoice.web;


import com.example.invoice.dto.EnteteVenteDTO;
import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.EnteteVente;
import com.example.invoice.service.EnteteService;
import com.example.invoice.fileGeneration.ReportService;
import com.example.invoice.service.impl.EnteteServiceImpl;
import com.example.invoice.service.mapper.EnteteMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/entetes-vente")
public class EnteteController {
    private EnteteServiceImpl enteteService;
    private ReportService reportService;
    private EnteteMapper enteteMapper;



    public EnteteController(EnteteServiceImpl enteteService, ReportService reportService , EnteteMapper enteteMapper){
        this.enteteService = enteteService;
        this.reportService = reportService;
        this.enteteMapper = enteteMapper;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<EnteteVenteDTO> addEntete(@RequestBody EnteteVenteDTO enteteDTO) {

        EnteteVente entete = enteteMapper.dtoToEntity(enteteDTO);
        EnteteVente entete1 = enteteService.saveEntete(entete);
        EnteteVenteDTO enteteVenteDTO = enteteMapper.entityToDto(entete1);
        return ResponseEntity.ok(enteteVenteDTO);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<EnteteVente> updateEntete(@RequestBody EnteteVenteDTO enteteDTO) {
        return ResponseEntity.ok(enteteService.updateEntete(enteteDTO));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<EnteteVenteDTO>> getAllEntetes() {

        List<EnteteVente> entetes = enteteService.getAllEntetes();
        List<EnteteVenteDTO> enteteVenteDTOS = entetes.stream()
                .map(entete -> enteteMapper.entityToDto(entete))
                .collect(Collectors.toList());
        return ResponseEntity.ok(enteteVenteDTOS);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<EnteteVenteDTO> getEnteteById(@PathVariable Long id) {
        EnteteVente entete = enteteService.getEnteteById(id);
        EnteteVenteDTO enteteDTO = enteteMapper.entityToDto(entete);
        return ResponseEntity.ok(enteteDTO);
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
        return ResponseEntity.ok().body(reportService.generateVente(id));
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
