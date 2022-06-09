package fr.univ_amu.iut;

import fr.univ_amu.iut.model.Usage;
import fr.univ_amu.iut.model.UsageAcademie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class RechercheUsage {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<Usage> query = em.createNamedQuery("Usage.findAll", Usage.class);
                List<Usage> usages = query.getResultList();
                System.out.println(usages.get(0));

            }
        }
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<Usage> query = em.createNamedQuery("Usage.findById", Usage.class);
                query.setParameter("id", 25);
                List<Usage> usage25 = query.getResultList();
                System.out.println(usage25);
            }
        }
    }

}
