package com.example.invoice.repository.achat;

import com.example.invoice.model.Achat;
import com.example.invoice.model.AchatCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AchatCustomRepo {
    Page<Achat> findByCriteria(AchatCriteria achatCriteria , Pageable pageable);
}
