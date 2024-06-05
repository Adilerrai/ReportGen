package com.example.invoice.repository;

import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.EnteteVente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnteteCriteriaRepo {


    Page<EnteteVente> findByCriteria(EnteteRechercheDTO enteteRechercheDTO, Pageable pageable);

    Page<EnteteVente> findByCriteriaHaving(EnteteRechercheDTO enteteRechercheDTO, Pageable pageable);

}
