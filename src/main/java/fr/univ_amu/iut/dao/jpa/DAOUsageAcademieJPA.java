package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOUsage;
import fr.univ_amu.iut.dao.DAOUsageAcademie;
import fr.univ_amu.iut.model.Usage;
import fr.univ_amu.iut.model.UsageAcademie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOUsageAcademieJPA implements DAOUsageAcademie {
    private final EntityManager entityManager;

    public DAOUsageAcademieJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UsageAcademie insert(UsageAcademie usageAcademie) {
        entityManager.getTransaction().begin();
        entityManager.persist(usageAcademie);
        entityManager.getTransaction().commit();

        return entityManager.find(UsageAcademie.class, usageAcademie.getIdUsage());
    }

    public boolean update(UsageAcademie obj) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(UsageAcademie obj) {
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
    public List<UsageAcademie> findByAcademie(String nomAcademie) {
        TypedQuery<UsageAcademie> query = entityManager.createNamedQuery("UsageAcademie.findByAcademie", UsageAcademie.class);
        return query.getResultList();

    }
    @Override
    public List<UsageAcademie> findAll() {
        TypedQuery<UsageAcademie> query = entityManager.createNamedQuery("UsageAcademie.findAll", UsageAcademie.class);
        return query.getResultList();
    }

    @Override
    public UsageAcademie getById(int id) {
        return null;
    }








}
