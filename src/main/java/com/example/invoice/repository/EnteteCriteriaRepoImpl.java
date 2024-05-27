package com.example.invoice.repository;


import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.EnteteFact;
import com.example.invoice.model.EnteteFact_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class EnteteCriteriaRepoImpl implements EnteteCriteriaRepo {

    private final EntityManager em;


    public EnteteCriteriaRepoImpl(EntityManager em) {
        this.em = em;
    }

    private Predicate[] generateWhere(CriteriaBuilder cb, Root<EnteteFact> rootEntete, EnteteRechercheDTO enteteRechercheDTO) {
        List<Predicate> predicates = new ArrayList<>();

//
//
//
        if (enteteRechercheDTO.getStatut()!=null){
            predicates.add(cb.equal(rootEntete.get(EnteteFact_.statut), enteteRechercheDTO.getStatut()));
        }

        if (enteteRechercheDTO.getNumeroFacture() != null) {
            predicates.add(cb.equal(rootEntete.get(EnteteFact_.numeroFacture), enteteRechercheDTO.getNumeroFacture()));
        }

if (enteteRechercheDTO.getDateFacture() != null) {
            predicates.add(cb.equal(rootEntete.get(EnteteFact_.dateFacture), enteteRechercheDTO.getDateFacture()));
        }

        if (enteteRechercheDTO.getModePaiement() != null) {
            predicates.add(cb.equal(rootEntete.get(EnteteFact_.modePaiement), enteteRechercheDTO.getModePaiement()));
        }
        if (enteteRechercheDTO.getClient() != null) {
            predicates.add(cb.equal(rootEntete.get("client"), enteteRechercheDTO.getClient()));
        }

    if (enteteRechercheDTO.getDetFactures() != null) {
            predicates.add(cb.equal(rootEntete.get("detFactures"), enteteRechercheDTO.getDetFactures() ));
        }

        return predicates.toArray(new Predicate[0]);
    }

    @Override
    public Page<EnteteFact> findByCriteria(EnteteRechercheDTO enteteRechercheDTO, Pageable pageable) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EnteteFact> cq = cb.createQuery(EnteteFact.class);
        Root<EnteteFact> enteteFact = cq.from(EnteteFact.class);

        Predicate[] predicates = this.generateWhere(cb, enteteFact, enteteRechercheDTO);

        cq.where(predicates);
        cq.select(enteteFact);

        // Execute the query and get the results
        TypedQuery<EnteteFact> query = em.createQuery(cq);
        List<EnteteFact> results = query.getResultList();



        // count lignes
        CriteriaQuery<Long> cqcount = cb.createQuery(Long.class);
        Root<EnteteFact> enteteFactCount = cqcount.from(EnteteFact.class);
        cqcount.select(cb.count(enteteFactCount));
        Predicate[] predicates2 = this.generateWhere(cb, enteteFactCount, enteteRechercheDTO);
        cqcount.where(predicates2);
        Long totalCount = em.createQuery(cqcount).getSingleResult();

        // Return the results as a Page
        return new PageImpl<>(results, pageable, totalCount);
    }
}
