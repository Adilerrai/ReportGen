package com.example.invoice.repository;

import com.example.invoice.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    @Query("select fournisseur from Fournisseur fournisseur join fournisseur.EnteteAchats EnteteAchat where EnteteAchat.id = ?1")
    Fournisseur getFournisseurByEnteteAchatId(Long id);
}
