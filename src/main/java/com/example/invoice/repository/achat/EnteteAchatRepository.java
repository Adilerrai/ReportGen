package com.example.invoice.repository.achat;

import com.example.invoice.model.EnteteAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository

public interface EnteteAchatRepository  extends JpaRepository<EnteteAchat, Long> {


    @Query("select EnteteAchat from EnteteAchat EnteteAchat join EnteteAchat.fournisseur fournisseur where fournisseur.id = ?1")
    List<EnteteAchat> findAllByFournisseurId(Long id);

    @Query("select EnteteAchat from EnteteAchat EnteteAchat where EnteteAchat.dateEnteteAchat between :startOfDay and :endOfDay")
    List<EnteteAchat> fetchAllEnteteAchatsForTheDay(@Param("startOfDay") Timestamp startOfDay, @Param("endOfDay") Timestamp endOfDay);

}
