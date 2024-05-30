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

public class AchatCustomRepoImpl implements AchatCustomRepo {


    EntityManager entityManager;

    public AchatCustomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    private Predicate generateWhere(AchatCriteria achatCriteria, CriteriaBuilder cb, Root<Achat> root) {
        {
            List<Predicate> predicates = new ArrayList<>();

            Join<Fournisseur, Achat> fournisseurAchatJoin = root.join("fournisseur", JoinType.INNER);

            if (achatCriteria.getFournisseurId() != null) {
                predicates.add(cb.equal(fournisseurAchatJoin.get(Fournisseur_.ID), achatCriteria.getFournisseurId()));
            }
            if (achatCriteria.getDateAchat() != null) {
                predicates.add(cb.equal(root.get(Achat_.DATE_ACHAT), achatCriteria.getDateAchat()));
            }
            if (achatCriteria.getStatusAchat() != null) {
                predicates.add(cb.equal(root.get(Achat_.STATUS_ACHAT), achatCriteria.getStatusAchat()));
            }
            if (achatCriteria.getDateRecherheDebut() != null && achatCriteria.getDateRechercheFin() != null) {
                predicates.add(cb.between(root.get(Achat_.DATE_ACHAT), achatCriteria.getDateRecherheDebut(), achatCriteria.getDateRechercheFin()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        }


    }


    @Override
    public Page<Achat> findByCriteria(AchatCriteria achatCriteria, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Achat> cq = cb.createQuery(Achat.class);

        Root<Achat> achatRoot = cq.from(Achat.class);
        Predicate predicate = generateWhere(achatCriteria, cb, achatRoot);

        cq.where(predicate);

        TypedQuery<Achat> query = entityManager.createQuery(cq);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<Achat> result = query.getResultList();

        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Achat> countRoot = countQuery.from(Achat.class);
        countQuery.select(cb.count(countRoot)).where(predicate);

        Long count = entityManager.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(result, pageable, count);
    }

}
