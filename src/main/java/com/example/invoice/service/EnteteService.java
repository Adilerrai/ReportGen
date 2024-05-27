package com.example.invoice.service;

import com.example.invoice.dto.EnteteFactDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EnteteService {
    public List<EnteteFactDTO> getAllEntetes();
    public EnteteFactDTO getEnteteById(Long id);
    public EnteteFactDTO saveEntete(EnteteFactDTO enteteDTO);
    public void deleteEntete(Long id);
    public EnteteFactDTO updateEntete(EnteteFactDTO enteteDTO);
}
