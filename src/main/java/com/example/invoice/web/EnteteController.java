package com.example.invoice.web;


import com.example.invoice.dto.EnteteFactDTO;
import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.EnteteFact;
import com.example.invoice.service.EnteteService;
import com.example.invoice.service.ReportService;
import com.example.invoice.service.mapper.EnteteMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entetes")
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
    public ResponseEntity<EnteteFactDTO> addEntete(@RequestBody EnteteFactDTO enteteDTO) {
        return ResponseEntity.ok(enteteService.saveEntete(enteteDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<EnteteFactDTO> updateEntete(@RequestBody EnteteFactDTO enteteDTO) {
        return ResponseEntity.ok(enteteService.updateEntete(enteteDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EnteteFactDTO>> getAllEntetes() {
        return ResponseEntity.ok(enteteService.getAllEntetes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnteteFactDTO> getEnteteById(@PathVariable Long id) {
        return ResponseEntity.ok(enteteService.getEnteteById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntete(@PathVariable Long id) {
        enteteService.deleteEntete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/reports/{id}")
    public ResponseEntity<String> generateReport(@PathVariable Long id) {
        return ResponseEntity.ok().body(reportService.generateReport(id));
    }


    @PostMapping("/multiple-search")
    public ResponseEntity<Page<EnteteFactDTO>> searchMultiple(@RequestBody EnteteRechercheDTO enteteFactDTO, Pageable pageable) {
        Page<EnteteFact> enteteFacts = enteteService.searchEnteteByCriteria (enteteFactDTO, pageable);
        Page<EnteteFactDTO> enteteFactDTOS = enteteFacts.map(enteteMapper::entityToDto);
        return ResponseEntity.ok(enteteFactDTOS);
    }

    @PostMapping("/multiple-search-having")
    public ResponseEntity<Page<EnteteFactDTO>> searchMultipleHaving(@RequestBody EnteteRechercheDTO enteteFactDTO, Pageable pageable) {
        Page<EnteteFact> enteteFacts = enteteService.searchEnteteByCriteriaHaving (enteteFactDTO, pageable);
        Page<EnteteFactDTO> enteteFactDTOS = enteteFacts.map(enteteMapper::entityToDto);
        return ResponseEntity.ok(enteteFactDTOS);
    }



}
