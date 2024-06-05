package com.example.invoice.service;

import com.example.invoice.model.EnteteAchat;
import com.example.invoice.model.EnteteAchatCriteria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EnteteAchatService {

    EnteteAchat creatEnteteAchat(EnteteAchat EnteteAchat);

    EnteteAchat updateEnteteAchat(EnteteAchat EnteteAchat);

    void deleteEnteteAchat(Long id);

    EnteteAchat getEnteteAchatById(Long id);

    List<EnteteAchat> getEnteteAchatByFournisseurId(Long id);


    Page<EnteteAchat> getAllEnteteAchatsPaginated(EnteteAchatCriteria EnteteAchatCriteria, Pageable pageable);


    EnteteAchat valideEnteteAchat(Long id);
}
