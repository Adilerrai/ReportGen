package com.example.invoice.service;

import com.example.invoice.dto.DetVenteDTO;



import java.util.List;
public interface DetFactService {
     List<DetVenteDTO> getAllDetFacts();
     DetVenteDTO getDetFactById(Long id);
     DetVenteDTO saveDetFact(DetVenteDTO detFactDTO);
     void deleteDetFact(Long id);
     DetVenteDTO updateDetFact(DetVenteDTO detFactDTO);
}
