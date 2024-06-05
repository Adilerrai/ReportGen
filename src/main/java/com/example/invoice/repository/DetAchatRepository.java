package com.example.invoice.repository;

import com.example.invoice.model.DetAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetAchatRepository extends JpaRepository<DetAchat, Long> {


    @Query("select DetAchat from DetAchat DetAchat join DetAchat.EnteteAchat EnteteAchat where EnteteAchat.id = ?1")
    List<DetAchat> findAllByEnteteAchatId(Long idEnteteAchat);
}
