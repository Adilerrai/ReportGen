package com.example.invoice.repository.achat;

import com.example.invoice.model.*;
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

public class EnteteAchatCustomRepoImpl implements EnteteAchatCustomRepo {


    EntityManager entityManager;

    public EnteteAchatCustomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    private Predicate generateWhere(EnteteAchatCriteria EnteteAchatCriteria, CriteriaBuilder cb, Root<EnteteAchat> root) {


        {
            List<Predicate> predicates = new ArrayList<>();

            Join<Fournisseur, EnteteAchat> fournisseurEnteteAchatJoin = root.join("fournisseur", JoinType.INNER);

            if (EnteteAchatCriteria.getFournisseurId() != null) {
                predicates.add(cb.equal(fournisseurEnteteAchatJoin.get(Fournisseur_.ID), EnteteAchatCriteria.getFournisseurId()));
            }

            if (EnteteAchatCriteria.getDateEnteteAchat() != null) {
                predicates.add(cb.equal(root.get(EnteteAchat_.dateEnteteAchat), EnteteAchatCriteria.getDateEnteteAchat()));
            }
            if (EnteteAchatCriteria.getStatusEnteteAchat() != null) {
                predicates.add(cb.equal(root.get(EnteteAchat_.statusEnteteAchat), EnteteAchatCriteria.getStatusEnteteAchat()));
            }
            if (EnteteAchatCriteria.getDateRecherheDebut() != null && EnteteAchatCriteria.getDateRechercheFin() != null) {
                predicates.add(cb.between(root.get(EnteteAchat_.dateEnteteAchat), EnteteAchatCriteria.getDateRecherheDebut(), EnteteAchatCriteria.getDateRechercheFin()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        }


    }


    @Override
    public Page<EnteteAchat> findByCriteria(EnteteAchatCriteria EnteteAchatCriteria, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EnteteAchat> cq = cb.createQuery(EnteteAchat.class);

        Root<EnteteAchat> EnteteAchatRoot = cq.from(EnteteAchat.class);
        Predicate predicate = generateWhere(EnteteAchatCriteria, cb, EnteteAchatRoot);

        cq.where(predicate);

        TypedQuery<EnteteAchat> query = entityManager.createQuery(cq);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<EnteteAchat> result = query.getResultList();

        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<EnteteAchat> countRoot = countQuery.from(EnteteAchat.class);
        Predicate countPredicate = generateWhere(EnteteAchatCriteria, cb, countRoot); // Create a new Predicate for the countQuery
        countQuery.select(cb.count(countRoot)).where(countPredicate);

        Long count = entityManager.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(result, pageable, count);
    }

}

















