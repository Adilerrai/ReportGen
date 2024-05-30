package com.example.invoice.service.impl;

import com.example.invoice.model.Fournisseur;
import com.example.invoice.repository.FournisseurRepository;
import com.example.invoice.service.FournisseurService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository fournisseurRepository;

public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }


    @Override
    public Fournisseur createFournisseur(Fournisseur fournisseur) {
        return  fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        Optional<Fournisseur> fournisseur1 = fournisseurRepository.findById(fournisseur.getId());
        if (fournisseur1 == null) {
            throw new RuntimeException("Fournisseur not found");
        } else {
            return fournisseurRepository.save(fournisseur);
        }
    }

    @Override
    public void deleteFournisseur(Long id) {

        fournisseurRepository.deleteById(id);
    }

    @Override
    public Fournisseur getFournisseurById(Long id) {
        return  fournisseurRepository.findById(id).orElse(null);
    }

    @Override
    public Fournisseur getFournisseurByAchatId(Long id) {
        return fournisseurRepository.getFournisseurByAchatId(id);
    }
}
