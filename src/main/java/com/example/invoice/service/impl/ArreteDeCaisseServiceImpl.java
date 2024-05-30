package com.example.invoice.service.impl;

import com.example.invoice.model.Achat;
import com.example.invoice.model.ArreteDeCaisse;
import com.example.invoice.model.EnteteFact;
import com.example.invoice.repository.AchatRepository;
import com.example.invoice.repository.ArreteDeCaisseRepository;
import com.example.invoice.repository.CaisseRepository;
import com.example.invoice.repository.EnteteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

import java.util.List;

@Service
public class ArreteDeCaisseServiceImpl {

    private final ArreteDeCaisseRepository arreteDeCaisseRepository;
    private final AchatRepository achatRepository;
    private final EnteteRepository enteteRepository;


    public ArreteDeCaisseServiceImpl(ArreteDeCaisseRepository arreteDeCaisseRepository, CaisseRepository caisseRepository, AchatRepository achatRepository, EnteteRepository enteteRepository) {
        this.arreteDeCaisseRepository = arreteDeCaisseRepository;
        this.achatRepository = achatRepository;
        this.enteteRepository = enteteRepository;
    }



    public ArreteDeCaisse createArreteDeCaisseParJour() {
        ArreteDeCaisse arreteDeCaisse = new ArreteDeCaisse();

        Timestamp startOfDay = Timestamp.valueOf(LocalDate.now().atStartOfDay());
        Timestamp endOfDay = Timestamp.valueOf(LocalDate.now().atTime(23, 59));


        List<Achat> achatList = achatRepository.fetchAllAchatsForTheDay(startOfDay, endOfDay);
        List<EnteteFact> enteteFacts = enteteRepository.fetchAllEnteteForTheDay(startOfDay, endOfDay);


        BigDecimal depense = achatList.stream().map(Achat::getTotalAchat).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalVente = enteteFacts.stream()
                .flatMap(enteteFact -> enteteFact.getDetFactures().stream())
                .filter(detFacture -> detFacture.getMontantTotalParProduit() != null)
                .map(detFacture -> detFacture.getMontantTotalParProduit())
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        arreteDeCaisse.setTotalDepense(depense);
        arreteDeCaisse.setTotalVente(totalVente);
        arreteDeCaisse.setTotalBenefice(totalVente.subtract(depense) );


        return arreteDeCaisseRepository.save(arreteDeCaisse);
    }



}
