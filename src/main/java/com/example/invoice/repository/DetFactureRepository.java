package com.example.invoice.repository;

import com.example.invoice.model.DetFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetFactureRepository extends JpaRepository<DetFacture, Long> {
}
