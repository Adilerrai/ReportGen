package com.example.invoice.repository;

import com.example.invoice.model.DetAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetAchatRepository extends JpaRepository<DetAchat, Long> {


    @Query("select detAchat from DetAchat detAchat join detAchat.achat achat where achat.id = ?1")
    List<DetAchat> findAllByAchatId(Long idAchat);
}
