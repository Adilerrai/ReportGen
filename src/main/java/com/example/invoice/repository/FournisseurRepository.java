package com.example.invoice.repository;

import com.example.invoice.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    @Query("select fournisseur from Fournisseur fournisseur join fournisseur.achats achat where achat.id = ?1")
    Fournisseur getFournisseurByAchatId(Long id);
}
