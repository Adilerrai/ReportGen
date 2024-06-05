package com.example.invoice.repository;

import com.example.invoice.model.DetVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetVenteRepository extends JpaRepository<DetVente, Long> {
}
