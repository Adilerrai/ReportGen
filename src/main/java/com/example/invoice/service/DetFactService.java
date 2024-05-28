package com.example.invoice.service;

import com.example.invoice.dto.DetFactureDTO;



import java.util.List;
public interface DetFactService {
     List<DetFactureDTO> getAllDetFacts();
     DetFactureDTO getDetFactById(Long id);
     DetFactureDTO saveDetFact(DetFactureDTO detFactDTO);
     void deleteDetFact(Long id);
     DetFactureDTO updateDetFact(DetFactureDTO detFactDTO);
}
