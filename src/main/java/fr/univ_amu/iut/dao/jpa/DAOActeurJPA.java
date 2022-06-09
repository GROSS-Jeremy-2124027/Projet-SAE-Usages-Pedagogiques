package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOActeur;
import fr.univ_amu.iut.model.Acteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOActeurJPA implements DAOActeur {
    private final EntityManager entityManager;

    public DAOActeurJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Acteur insert(Acteur acteur) {
        entityManager.getTransaction().begin();
        entityManager.persist(acteur);
        entityManager.getTransaction().commit();

        return entityManager.find(Acteur.class, acteur.getId());
    }

    public boolean update(Acteur obj) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(Acteur obj) {
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
    public List<Acteur> findAll() {
        TypedQuery<Acteur> query = entityManager.createNamedQuery("Acteur.findAll", Acteur.class);
        return query.getResultList();
    }

    @Override
    public List<Acteur> findById(int id) {
        return null;
    }

    @Override
    public Acteur getById(int id) {
        TypedQuery<Acteur> query = entityManager.createNamedQuery("Acteur.findById", Acteur.class);
        query.setParameter("numEt", id);
        return query.getSingleResult();
    }
}
