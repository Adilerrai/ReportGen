package com.example.invoice.service;

import com.example.invoice.model.Caisse;

public interface CaisseService {

    Caisse update (Caisse caisse);

    Caisse createCaisse(Caisse caisse);

    Caisse getCaisse(Long id);

    void deleteCaisse(Long id);


    //ttest
}
