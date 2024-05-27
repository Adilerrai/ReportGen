package com.example.invoice.repository;

import com.example.invoice.dto.EnteteFactDTO;
import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.EnteteFact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnteteCriteriaRepo {


    Page<EnteteFact> findByCriteria(EnteteRechercheDTO enteteRechercheDTO, Pageable pageable);

    Page<EnteteFact> findByCriteriaHaving(EnteteRechercheDTO enteteRechercheDTO, Pageable pageable);
}
