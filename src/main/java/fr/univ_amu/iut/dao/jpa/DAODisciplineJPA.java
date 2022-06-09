package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAODiscipline;
import fr.univ_amu.iut.model.Discipline;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAODisciplineJPA implements DAODiscipline {
    private final EntityManager entityManager;

    public DAODisciplineJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Discipline insert(Discipline discipline) {
        entityManager.getTransaction().begin();
        entityManager.persist(discipline);
        entityManager.getTransaction().commit();

        return entityManager.find(Discipline.class, discipline.getNom());
    }

    public boolean update(Discipline obj) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(Discipline obj) {
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
    public boolean delete(DAODiscipline obj) {
        return false;
    }

    @Override
    public List<DAODiscipline> findAll() {
        return null;
    }

    @Override
    public DAODiscipline getById(int id) {
        return null;
    }

    @Override
    public DAODiscipline insert(DAODiscipline obj) {
        return null;
    }

    @Override
    public boolean update(DAODiscipline obj) {
        return false;
    }

    @Override
    public List<Discipline> findByNom(String nom) {
        return null;
    }
}
