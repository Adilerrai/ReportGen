package com.example.invoice.repository;

import com.example.invoice.model.EnteteFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnteteRepository  extends JpaRepository<EnteteFact, Long> {
}
