package com.example.invoice.service;

import com.example.invoice.dto.EnteteVenteDTO;
import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.EnteteVente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public interface EnteteService {
     List<EnteteVenteDTO> getAllEntetes();
     EnteteVenteDTO getEnteteById(Long id);
     EnteteVenteDTO saveEntete(EnteteVenteDTO enteteDTO);
     void deleteEntete(Long id);
     EnteteVenteDTO updateEntete(EnteteVenteDTO enteteDTO);

    Page<EnteteVente> searchEnteteByCriteria(EnteteRechercheDTO EnteteVenteDTO  , Pageable pageable);

    Page<EnteteVente> searchEnteteByCriteriaHaving(EnteteRechercheDTO EnteteVenteDTO  , Pageable pageable);


    @Query(nativeQuery = true,  value = "SELECT * FROM entete_fact WHERE id = ?1")
    EnteteVente findEnteteById(Long id);


}
