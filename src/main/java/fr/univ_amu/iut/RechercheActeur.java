package fr.univ_amu.iut;

import fr.univ_amu.iut.model.Acteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RechercheActeur {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")){
            try(EntityManager em = emf.createEntityManager()){
                TypedQuery<Acteur> query = em.createNamedQuery("Discipline.findAll", Acteur.class);
                //query.setParameter("annee",1);
                List <Acteur> a = query.getResultList();
                System.out.println(a.get(0));
            }
        }
    }
}
