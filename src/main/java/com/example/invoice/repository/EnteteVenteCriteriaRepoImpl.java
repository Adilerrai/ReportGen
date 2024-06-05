package com.example.invoice.repository;
import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.DetVente;
import com.example.invoice.model.EnteteVente;
//

import com.example.invoice.model.EnteteVente_;
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
public class EnteteVenteCriteriaRepoImpl implements EnteteCriteriaRepo {

    private EntityManager em;


    public void EnteteVenteCriteriaRepoImpl(EntityManager em) {
        this.em = em;
    }

    public EnteteVenteCriteriaRepoImpl(EntityManager em) {
        this.em = em;
    }

    private Predicate[] generateWhere(CriteriaBuilder cb, Root<EnteteVente> rootEntete, EnteteRechercheDTO enteteRechercheDTO) {
        List<Predicate> predicates = new ArrayList<>();




        if (enteteRechercheDTO.getStatut()!=null){
            predicates.add(cb.equal(rootEntete.get(EnteteVente_.statut), enteteRechercheDTO.getStatut()));
        }

        if (enteteRechercheDTO.getNumeroFacture() != null) {
            predicates.add(cb.equal(rootEntete.get(EnteteVente_.numeroFacture), enteteRechercheDTO.getNumeroFacture()));
        }

        if (enteteRechercheDTO.getDateFacture() != null) {
            predicates.add(cb.equal(rootEntete.get(EnteteVente_.dateFacture), enteteRechercheDTO.getDateFacture()));
        }

        if (enteteRechercheDTO.getModePaiement() != null) {
            predicates.add(cb.equal(rootEntete.get(EnteteVente_.modePaiement), enteteRechercheDTO.getModePaiement()));
        }
        if (enteteRechercheDTO.getClient() != null) {
            predicates.add(cb.equal(rootEntete.get("client"), enteteRechercheDTO.getClient()));
        }

        if (enteteRechercheDTO.getDetVentes() != null && rootEntete.get("DetVentes") != null) {
            predicates.add(cb.equal(rootEntete.get("DetVentes"), enteteRechercheDTO.getDetVentes()));
        }

        return predicates.toArray(new Predicate[0]);
    }

    @Override
    public Page<EnteteVente> findByCriteria(EnteteRechercheDTO enteteRechercheDTO, Pageable pageable) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EnteteVente> cq = cb.createQuery(EnteteVente.class);
        Root<EnteteVente> EnteteVente = cq.from(EnteteVente.class);

        Predicate[] predicates = this.generateWhere(cb, EnteteVente, enteteRechercheDTO);

        cq.where(predicates);
        cq.select(EnteteVente);

        // Execute the query and get the results
        TypedQuery<EnteteVente> query = em.createQuery(cq);
        List<EnteteVente> results = query.getResultList();



        // count lignes
        CriteriaQuery<Long> cqcount = cb.createQuery(Long.class);
        Root<EnteteVente> EnteteVenteCount = cqcount.from(EnteteVente.class);
        cqcount.select(cb.count(EnteteVenteCount));
        Predicate[] predicates2 = this.generateWhere(cb, EnteteVenteCount, enteteRechercheDTO);
        cqcount.where(predicates2);
        Long totalCount = em.createQuery(cqcount).getSingleResult();

        // Return the results as a Page
        return new PageImpl<>(results, pageable, totalCount);
    }


    @Override
    public Page<EnteteVente> findByCriteriaHaving(EnteteRechercheDTO enteteRechercheDTO, Pageable pageable) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EnteteVente> cq = cb.createQuery(EnteteVente.class);
        Root<EnteteVente> EnteteVente = cq.from(EnteteVente.class);

        Predicate[] predicates = this.generateWhere(cb, EnteteVente, enteteRechercheDTO);

        Join<EnteteVente, DetVente> DetVentesJoin = EnteteVente.join("DetVentes", JoinType.INNER);
        Expression<Long> DetVentesCount = cb.count(DetVentesJoin);
        // Add a HAVING clause
        Expression<Long> five = cb.literal(1L);
        cq.having(cb.greaterThan(DetVentesCount, five));
        // Add an ORDER BY clause
        cq.orderBy(cb.asc(EnteteVente.get(EnteteVente_.numeroFacture)));

        // Add a GROUP BY clause
        cq.groupBy(EnteteVente);

        cq.where(predicates);
        cq.select(EnteteVente);

        // Execute the query and get the results
        TypedQuery<EnteteVente> query = em.createQuery(cq);
        List<EnteteVente> results = query.getResultList();

        // count lignes
        CriteriaQuery<Long> cqcount = cb.createQuery(Long.class);
        Root<EnteteVente> EnteteVenteCount = cqcount.from(EnteteVente.class);
        cqcount.select(cb.count(EnteteVenteCount));
        Predicate[] predicates2 = this.generateWhere(cb, EnteteVenteCount, enteteRechercheDTO);
        cqcount.where(predicates2);
        Long totalCount = em.createQuery(cqcount).getSingleResult();

        // Return the results as a Page
        return new PageImpl<>(results, pageable, totalCount);
    }
}
