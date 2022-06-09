package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOUsageDiscipline;
import fr.univ_amu.iut.dao.DAOUsageThematique;
import fr.univ_amu.iut.model.Usage;
import fr.univ_amu.iut.model.UsageDiscipline;
import fr.univ_amu.iut.model.UsageThematique;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOUsageDisciplineJPA implements DAOUsageDiscipline {
    private final EntityManager entityManager;

    public DAOUsageDisciplineJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UsageDiscipline insert(UsageDiscipline usageDiscipline) {
        entityManager.getTransaction().begin();
        entityManager.persist(usageDiscipline);
        entityManager.getTransaction().commit();

        return entityManager.find(UsageDiscipline.class, usageDiscipline.getIdUsage());
    }

    public boolean update(UsageDiscipline obj) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(UsageDiscipline obj) {
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
    public List<UsageDiscipline> findByDiscipline(int idDiscipline) {
        TypedQuery<UsageDiscipline> query = entityManager.createNamedQuery("UsageDiscipline.findByDiscipline", UsageDiscipline.class);
        return query.getResultList();

    }
    @Override
    public List<UsageDiscipline> findAll() {
        TypedQuery<UsageDiscipline> query = entityManager.createNamedQuery("UsageDiscipline.findAll", UsageDiscipline.class);
        return query.getResultList();
    }
    @Override
    public UsageDiscipline getById(int id) {
        return null;
    }







}
