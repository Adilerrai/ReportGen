package com.example.invoice.service;

import com.example.invoice.model.Fournisseur;
import org.springframework.data.jpa.repository.Query;

public interface FournisseurService {

    Fournisseur createFournisseur(Fournisseur fournisseur);

    Fournisseur updateFournisseur(Fournisseur fournisseur);

    void deleteFournisseur(Long id);

    Fournisseur getFournisseurById(Long id);


    Fournisseur getFournisseurByEnteteAchatId(Long id);

}
