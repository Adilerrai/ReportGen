package com.example.invoice.repository.achat;

import com.example.invoice.model.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository

public interface AchatRepository  extends JpaRepository<Achat, Long> {


    @Query("select achat from Achat achat join achat.fournisseur fournisseur where fournisseur.id = ?1")
    List<Achat> findAllByFournisseurId(Long id);

    @Query("select achat from Achat achat where achat.dateAchat between :startOfDay and :endOfDay")
    List<Achat> fetchAllAchatsForTheDay(@Param("startOfDay") Timestamp startOfDay, @Param("endOfDay") Timestamp endOfDay);}
