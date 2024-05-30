package com.example.invoice.repository;

import com.example.invoice.model.ArreteDeCaisse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ArreteDeCaisseRepository extends JpaRepository<ArreteDeCaisse, Long>    {
}
