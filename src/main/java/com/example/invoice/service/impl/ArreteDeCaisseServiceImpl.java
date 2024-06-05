package com.example.invoice.service.impl;

import com.example.invoice.model.EnteteAchat;
import com.example.invoice.model.ArreteDeCaisse;
import com.example.invoice.model.EnteteVente;
import com.example.invoice.repository.ArreteDeCaisseRepository;
import com.example.invoice.repository.CaisseRepository;
import com.example.invoice.repository.EnteteRepository;
import com.example.invoice.repository.achat.EnteteAchatRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

import java.util.List;

@Service
public class ArreteDeCaisseServiceImpl {

    private final ArreteDeCaisseRepository arreteDeCaisseRepository;
    private final EnteteAchatRepository enteteAchatRepository;
    private final EnteteRepository enteteRepository;


    public ArreteDeCaisseServiceImpl(ArreteDeCaisseRepository arreteDeCaisseRepository, CaisseRepository caisseRepository, EnteteAchatRepository EnteteAchatRepository, EnteteRepository enteteRepository) {
        this.arreteDeCaisseRepository = arreteDeCaisseRepository;
        this.enteteAchatRepository = EnteteAchatRepository;
        this.enteteRepository = enteteRepository;
    }



    public ArreteDeCaisse createArreteDeCaisseParJour() {
        ArreteDeCaisse arreteDeCaisse = new ArreteDeCaisse();

        Timestamp startOfDay = Timestamp.valueOf(LocalDate.now().atStartOfDay());
        Timestamp endOfDay = Timestamp.valueOf(LocalDate.now().atTime(23, 59));


        List<EnteteAchat> EnteteAchatList = enteteAchatRepository.fetchAllEnteteAchatsForTheDay(startOfDay, endOfDay);
        List<EnteteVente> EnteteVentes = enteteRepository.fetchAllEnteteForTheDay(startOfDay, endOfDay);


        BigDecimal depense = EnteteAchatList.stream().map(EnteteAchat::getTotalEnteteAchat).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalVente = EnteteVentes.stream()
                .flatMap(EnteteVente -> EnteteVente.getDetVentes().stream())
                .filter(DetVente -> DetVente.getMontantTotalParProduit() != null)
                .map(DetVente -> DetVente.getMontantTotalParProduit())
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        arreteDeCaisse.setTotalDepense(depense);
        arreteDeCaisse.setTotalVente(totalVente);
        arreteDeCaisse.setTotalBenefice(totalVente.subtract(depense) );


        return arreteDeCaisseRepository.save(arreteDeCaisse);
    }



}
