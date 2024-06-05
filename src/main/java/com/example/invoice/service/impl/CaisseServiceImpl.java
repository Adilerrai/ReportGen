package com.example.invoice.service.impl;

import com.example.invoice.model.Caisse;
import com.example.invoice.repository.CaisseRepository;
import com.example.invoice.service.CaisseService;
import org.springframework.stereotype.Service;


@Service
public class CaisseServiceImpl implements CaisseService {

    private final CaisseRepository caisseRepository;

    public CaisseServiceImpl(CaisseRepository caisseRepository) {
        this.caisseRepository = caisseRepository;
    }



    @Override
    public Caisse update(Caisse caisse) {
        return null;
    }


    @Override
    public Caisse createCaisse(Caisse caisse) {
            if (caisseRepository.count() > 0) {
                throw new RuntimeException("Caisse existe déjà");
            }
            return caisseRepository.save(caisse);
        }

    @Override
    public Caisse getCaisse(Long id) {

        Caisse caisse = caisseRepository.findById(id).orElse(null);
        if (caisse == null) {
            throw new RuntimeException("Caisse non trouvé");
        }
        caisse.setDifference(caisse.getTotalVentes().subtract(caisse.getTotalEnteteAchats()));

        return caisseRepository.findById(id).get();

    }

    @Override
    public void deleteCaisse(Long id) {

    }


}
