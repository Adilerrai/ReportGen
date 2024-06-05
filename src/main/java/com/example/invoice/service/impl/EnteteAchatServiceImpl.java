package com.example.invoice.service.impl;

import com.example.invoice.enums.StatusEnteteAchat;
import com.example.invoice.model.*;

import com.example.invoice.repository.CaisseRepository;
import com.example.invoice.repository.DetAchatRepository;
import com.example.invoice.repository.ProduitRepository;
import com.example.invoice.repository.achat.EnteteAchatCustomRepo;
import com.example.invoice.repository.achat.EnteteAchatRepository;
import com.example.invoice.service.EnteteAchatService;
import com.example.invoice.service.FournisseurService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;


@Service
public class EnteteAchatServiceImpl implements EnteteAchatService {

    private  final EnteteAchatRepository enteteAchatRepository;

    private final FournisseurService fournisseurService;

    public  final ProduitRepository produitRepository;

    private final CaisseRepository caisseRepository;

    private final DetAchatRepository DetAchatRepository;

    private  final EnteteAchatCustomRepo enteteAchatCustomRepo;





    public EnteteAchatServiceImpl(EnteteAchatRepository enteteAchatRepository, FournisseurService fournisseurService, ProduitRepository produitRepository, CaisseRepository caisseRepository, DetAchatRepository DetAchatRepository, EnteteAchatCustomRepo enteteAchatCustomRepo) {
        this.enteteAchatRepository = enteteAchatRepository;
        this.fournisseurService = fournisseurService;
        this.produitRepository = produitRepository;
        this.caisseRepository = caisseRepository;
        this.DetAchatRepository = DetAchatRepository;
        this.enteteAchatCustomRepo = enteteAchatCustomRepo;
    }


    @Override
    public EnteteAchat creatEnteteAchat(EnteteAchat EnteteAchat) {
        BigDecimal totalEnteteAchat = BigDecimal.ZERO;

        EnteteAchat.setDateEnteteAchat(new java.sql.Date(System.currentTimeMillis()));

        EnteteAchat = enteteAchatRepository.save(EnteteAchat);

        for (DetAchat DetAchat : EnteteAchat.getDetAchats()) {
            Produit produit = produitRepository.findById(DetAchat.getProduit().getId())
                    .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

            int newQuantite = produit.getQuantite() + DetAchat.getQuantiteAchete();

            produit.setQuantite(newQuantite);
            produitRepository.save(produit);

            Caisse caisse = caisseRepository.findById(1L)
                    .orElseThrow(() -> new RuntimeException("Caisse non trouvée"));

            caisse.setDifference(caisse.getDifference()
                    .add(BigDecimal.valueOf(DetAchat.getQuantiteAchete())
                            .multiply(BigDecimal.valueOf(DetAchat.getPrixUnitaire()))));

            BigDecimal totalDetAchat = BigDecimal.valueOf(DetAchat.getQuantiteAchete()).multiply(BigDecimal.valueOf(DetAchat.getPrixUnitaire()));
            DetAchat.setTotalParProduit(totalDetAchat); // set the total for this DetAchat
            totalEnteteAchat = totalEnteteAchat.add(totalDetAchat);

            DetAchat newDetAchat = new DetAchat();
            newDetAchat.setProduit(produit);
            newDetAchat.setEnteteAchat(EnteteAchat);
            newDetAchat.setQuantiteAchete(DetAchat.getQuantiteAchete());
            newDetAchat.setPrixUnitaire(DetAchat.getPrixUnitaire());
            newDetAchat.setTotalParProduit(totalDetAchat); // set the total for the new DetAchat

            System.out.println(newDetAchat.getTotalParProduit());
            DetAchatRepository.save(newDetAchat);
        }

        EnteteAchat.setTotalEnteteAchat(totalEnteteAchat);

        Caisse caisse = caisseRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Caisse non trouvée"));

        caisse.setTotalEnteteAchats(caisse.getTotalEnteteAchats().add(totalEnteteAchat));
        caisse.setDifference(caisse.getDifference().subtract(totalEnteteAchat) );
        caisseRepository.save(caisse);

        return EnteteAchat;
    }


    @Override
    public EnteteAchat updateEnteteAchat(EnteteAchat EnteteAchat) {
        return enteteAchatRepository.save(EnteteAchat);
    }

    @Override
    public void deleteEnteteAchat(Long id) {

        enteteAchatRepository.deleteById(id);
    }

    @Override
    public EnteteAchat getEnteteAchatById(Long id) {
        return enteteAchatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EnteteAchat non trouvé"));
    }

    @Override
    public List<EnteteAchat> getEnteteAchatByFournisseurId(Long id) {

    return enteteAchatRepository.findAllByFournisseurId(id);
}

    @Override
    public Page<EnteteAchat> getAllEnteteAchatsPaginated(EnteteAchatCriteria EnteteAchatCriteria, Pageable pageable) {
        return enteteAchatCustomRepo.findByCriteria(EnteteAchatCriteria, pageable);
    }


    @Override
    public EnteteAchat valideEnteteAchat(Long id) {
        EnteteAchat EnteteAchat = enteteAchatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EnteteAchat non trouvé"));

        if (EnteteAchat.getStatusEnteteAchat().equals(StatusEnteteAchat.REGLE)) {
            throw new RuntimeException("EnteteAchat déjà validé");
        }
        EnteteAchat.setStatusEnteteAchat(StatusEnteteAchat.REGLE);
                return enteteAchatRepository.save(EnteteAchat);
    }


}
