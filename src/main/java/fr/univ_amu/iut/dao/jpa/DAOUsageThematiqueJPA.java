package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOUsageAcademie;
import fr.univ_amu.iut.dao.DAOUsageThematique;
import fr.univ_amu.iut.model.UsageAcademie;
import fr.univ_amu.iut.model.UsageThematique;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOUsageThematiqueJPA implements DAOUsageThematique {
    private final EntityManager entityManager;

    public DAOUsageThematiqueJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UsageThematique insert(UsageThematique usageThematique) {
        entityManager.getTransaction().begin();
        entityManager.persist(usageThematique);
        entityManager.getTransaction().commit();

        return entityManager.find(UsageThematique.class, usageThematique.getIdUsage());
    }

    public boolean update(UsageThematique obj) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(UsageThematique obj) {
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
    public List<UsageThematique> findByThematique(String nomThematique) {
        TypedQuery<UsageThematique> query = entityManager.createNamedQuery("UsageThematique.findByThematique", UsageThematique.class);
        return query.getResultList();

    }
    @Override
    public List<UsageThematique> findAll() {
        TypedQuery<UsageThematique> query = entityManager.createNamedQuery("UsageThematique.findAll", UsageThematique.class);
        return query.getResultList();
    }
    @Override
    public UsageThematique getById(int id) {
        return null;
    }







}
