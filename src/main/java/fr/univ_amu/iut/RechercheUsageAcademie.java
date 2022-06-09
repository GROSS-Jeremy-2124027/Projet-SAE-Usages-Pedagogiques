package fr.univ_amu.iut;

import fr.univ_amu.iut.model.Usage;
import fr.univ_amu.iut.model.UsageAcademie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class RechercheUsageAcademie {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageAcademie> query = em.createNamedQuery("UsageAcademie.findAll", UsageAcademie.class);
                List<UsageAcademie> usagesAcademie = query.getResultList();
                System.out.println(usagesAcademie);

            }
        }
       try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageAcademie> query = em.createNamedQuery("UsageAcademie.findByAcademie", UsageAcademie.class);
                query.setParameter("nomAcademie", "ACADEMIE DE VERSAILLES");
                List<UsageAcademie> usagesAcademieParis = query.getResultList();
                for (int i = 0; i < usagesAcademieParis.size(); ++i)
                    System.out.println(usagesAcademieParis.get(i));


            }
        }

       /*
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageAcademie> query = em.createNamedQuery("UsageAcademie.findByAcademie", UsageAcademie.class);
                query.setParameter("codeAcademie", "VE");
                List<UsageAcademie> usagesAcademieVersailles = query.getResultList();
                int id = usagesAcademieVersailles.get(0).getId();
                System.out.println(id);
                //join artisanal
                TypedQuery<Usage> query2 = em.createNamedQuery("Usage.findById", Usage.class);
                query2.setParameter("id", id);
                List<Usage> usage = query2.getResultList();
                System.out.println(usage);
            }
        }
        = new ArrayList<>();*/


    }

}