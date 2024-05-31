package com.example.invoice.service.impl;

import com.example.invoice.enums.StatusAchat;
import com.example.invoice.model.*;
import com.example.invoice.repository.achat.AchatCustomRepo;
import com.example.invoice.repository.achat.AchatRepository;
import com.example.invoice.repository.CaisseRepository;
import com.example.invoice.repository.DetAchatRepository;
import com.example.invoice.repository.ProduitRepository;
import com.example.invoice.service.AchatService;
import com.example.invoice.service.FournisseurService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;


@Service
public class AchatServiceImpl implements AchatService {

    private  final AchatRepository achatRepository;

    private final FournisseurService fournisseurService;

    public  final ProduitRepository produitRepository;

    private final CaisseRepository caisseRepository;

    private final DetAchatRepository detAchatRepository;

    private  final AchatCustomRepo achatCustomRepo;





    public AchatServiceImpl(AchatRepository achatRepository, FournisseurService fournisseurService, ProduitRepository produitRepository, CaisseRepository caisseRepository, DetAchatRepository detAchatRepository, AchatCustomRepo achatCustomRepo) {
        this.achatRepository = achatRepository;
        this.fournisseurService = fournisseurService;
        this.produitRepository = produitRepository;
        this.caisseRepository = caisseRepository;
        this.detAchatRepository = detAchatRepository;
        this.achatCustomRepo = achatCustomRepo;
    }


    @Override
    public Achat creatAchat(Achat achat) {
        BigDecimal totalAchat = BigDecimal.ZERO;

        achat.setDateAchat(new java.sql.Date(System.currentTimeMillis()));

        // Save Achat first
        achat = achatRepository.save(achat);

        // Create new DetAchat and update the quantity of the product
        for (DetAchat detAchat : achat.getDetAchats()) {
            Produit produit = produitRepository.findById(detAchat.getProduit().getId())
                    .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

            int newQuantite = produit.getQuantite() + detAchat.getQuantiteAchete();

            produit.setQuantite(newQuantite);
            produitRepository.save(produit);

            Caisse caisse = caisseRepository.findById(1L)
                    .orElseThrow(() -> new RuntimeException("Caisse non trouvée"));

            caisse.setDifference(caisse.getDifference()
                    .add(BigDecimal.valueOf(detAchat.getQuantiteAchete())
                            .multiply(BigDecimal.valueOf(detAchat.getPrixUnitaire()))));

            BigDecimal totalDetAchat = BigDecimal.valueOf(detAchat.getQuantiteAchete()).multiply(BigDecimal.valueOf(detAchat.getPrixUnitaire()));
            totalAchat = totalAchat.add(totalDetAchat);

            // Create new DetAchat
            DetAchat newDetAchat = new DetAchat();
            newDetAchat.setProduit(produit);
            newDetAchat.setAchat(achat);
            newDetAchat.setQuantiteAchete(detAchat.getQuantiteAchete());
            newDetAchat.setPrixUnitaire(detAchat.getPrixUnitaire());
            detAchatRepository.save(newDetAchat);
        }

        achat.setTotalAchat(totalAchat);

        // Update Caisse
        Caisse caisse = caisseRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Caisse non trouvée"));

        caisse.setTotalAchats(caisse.getTotalAchats().add(totalAchat));
        caisse.setDifference(caisse.getDifference().subtract(totalAchat) );
        caisseRepository.save(caisse);

        return achat;
    }



    @Override
    public Achat updateAchat(Achat achat) {
        return achatRepository.save(achat);
    }

    @Override
    public void deleteAchat(Long id) {

        achatRepository.deleteById(id);
    }

    @Override
    public Achat getAchatById(Long id) {
        return achatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Achat non trouvé"));
    }

    @Override
    public List<Achat> getAchatByFournisseurId(Long id) {

    return achatRepository.findAllByFournisseurId(id);
}

    @Override
    public Page<Achat> getAllAchatsPaginated(AchatCriteria achatCriteria, Pageable pageable) {
        return achatCustomRepo.findByCriteria(achatCriteria, pageable);
    }


    @Override
    public Achat valideAchat(Long id) {
        Achat achat = achatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Achat non trouvé"));

        achat.setStatusAchat(StatusAchat.REGLE);
                return achatRepository.save(achat);
    }


}
