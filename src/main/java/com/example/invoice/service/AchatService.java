package com.example.invoice.service;

import com.example.invoice.model.Achat;
import com.example.invoice.model.AchatCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AchatService {

    Achat creatAchat(Achat achat);

    Achat updateAchat(Achat achat);

    void deleteAchat(Long id);

    Achat getAchatById(Long id);

    List<Achat> getAchatByFournisseurId(Long id);


    Page<Achat> getAllAchatsPaginated(AchatCriteria achatCriteria, Pageable pageable);




}
