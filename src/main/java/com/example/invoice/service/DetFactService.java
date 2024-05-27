package com.example.invoice.service;

import com.example.invoice.dto.DetFactureDTO;
import org.springframework.stereotype.Service;

import java.util.List;
public interface DetFactService {
    public List<DetFactureDTO> getAllDetFacts();
    public DetFactureDTO getDetFactById(Long id);
    public DetFactureDTO saveDetFact(DetFactureDTO detFactDTO);
    public void deleteDetFact(Long id);
    public DetFactureDTO updateDetFact(DetFactureDTO detFactDTO);
}
