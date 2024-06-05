package com.example.invoice.repository.achat;

import com.example.invoice.model.EnteteAchat;
import com.example.invoice.model.EnteteAchatCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnteteAchatCustomRepo {
    Page<EnteteAchat> findByCriteria(EnteteAchatCriteria EnteteAchatCriteria , Pageable pageable);
}
