package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOUsage;
import fr.univ_amu.iut.model.Usage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOUsageJPA implements DAOUsage {
    private final EntityManager entityManager;

    public DAOUsageJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Usage insert(Usage usage) {
        entityManager.getTransaction().begin();
        entityManager.persist(usage);
        entityManager.getTransaction().commit();

        return entityManager.find(Usage.class, usage.getId());
    }

    public boolean update(Usage obj) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(Usage obj) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(obj);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Usage> findById(int id) {
        TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findById", Usage.class);
        return query.getResultList();
    }

    @Override
    public List<Usage> findAll() {
        TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findAll", Usage.class);
        return query.getResultList();
    }

    @Override
    public Usage getById(int id) {
        return null;
    }








}
