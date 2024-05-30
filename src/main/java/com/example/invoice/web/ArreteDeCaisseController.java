package com.example.invoice.web;


import com.example.invoice.dto.ArreteDeCaisseDTO;
import com.example.invoice.model.ArreteDeCaisse;
import com.example.invoice.service.impl.ArreteDeCaisseServiceImpl;
import com.example.invoice.service.mapper.ArreteDeCaisseMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/arrete-de-caisse")
@RestController
public class ArreteDeCaisseController {


    private final ArreteDeCaisseServiceImpl arreteDeCaisseService;

    private final ArreteDeCaisseMapper arreteDeCaisseMapper;

    public ArreteDeCaisseController(ArreteDeCaisseServiceImpl arreteDeCaisseService, ArreteDeCaisseMapper arreteDeCaisseMapper) {
        this.arreteDeCaisseService = arreteDeCaisseService;
        this.arreteDeCaisseMapper = arreteDeCaisseMapper;
    }


    @GetMapping("/get-arrete-de-caisse/")
    public ResponseEntity<ArreteDeCaisseDTO> getArreteDeCaisse() {
        ArreteDeCaisse arreteDeCaisse = arreteDeCaisseService.createArreteDeCaisseParJour();
        return ResponseEntity.ok(arreteDeCaisseMapper.entityToDto(arreteDeCaisse));
    }


}
