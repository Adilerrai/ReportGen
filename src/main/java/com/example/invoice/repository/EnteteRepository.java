package com.example.invoice.repository;

import com.example.invoice.model.EnteteFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface EnteteRepository  extends JpaRepository<EnteteFact, Long> {

    @Query("select entet from EnteteFact entet where entet.createdDate between :startOfDay and :endOfDay")
    List<EnteteFact> fetchAllEnteteForTheDay(@Param("startOfDay") Timestamp startOfDay, @Param("endOfDay") Timestamp endOfDay);



}
