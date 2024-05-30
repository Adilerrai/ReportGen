package com.example.invoice.repository;

import com.example.invoice.model.Caisse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CaisseRepository extends JpaRepository<Caisse, Long>{
}
