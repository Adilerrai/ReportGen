package com.example.invoice.service;

import com.example.invoice.dto.EnteteFactDTO;
import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.EnteteFact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.lang.annotation.Native;
import java.util.List;
@Service
public interface EnteteService {
    public List<EnteteFactDTO> getAllEntetes();
    public EnteteFactDTO getEnteteById(Long id);
    public EnteteFactDTO saveEntete(EnteteFactDTO enteteDTO);
    public void deleteEntete(Long id);
    public EnteteFactDTO updateEntete(EnteteFactDTO enteteDTO);

    Page<EnteteFact> searchEnteteByCriteria(EnteteRechercheDTO enteteFactDTO  , Pageable pageable);

    Page<EnteteFact> searchEnteteByCriteriaHaving(EnteteRechercheDTO enteteFactDTO  , Pageable pageable);


    @Query(nativeQuery = true,  value = "SELECT * FROM entete_fact WHERE id = ?1")
    EnteteFact findEnteteById(Long id);


}
