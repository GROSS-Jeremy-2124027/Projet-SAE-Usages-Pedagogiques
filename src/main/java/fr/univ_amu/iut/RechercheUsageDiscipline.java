package fr.univ_amu.iut;

import fr.univ_amu.iut.model.Usage;
import fr.univ_amu.iut.model.UsageDiscipline;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class RechercheUsageDiscipline {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageDiscipline> query = em.createNamedQuery("UsageDiscipline.findAll", UsageDiscipline.class);
                List<UsageDiscipline> usageDisciplines = query.getResultList();
                System.out.println(usageDisciplines);
            }
        }
         try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageDiscipline> query = em.createNamedQuery("UsageDiscipline.findByDiscipline", UsageDiscipline.class);
                query.setParameter("idUsage", 1);
                List<UsageDiscipline> usageDisciplineToutes = query.getResultList();
               // System.out.println(usageDisciplineToutes);


            }
        }
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageDiscipline> query = em.createNamedQuery("UsageDiscipline.findByDiscipline", UsageDiscipline.class);
                query.setParameter("idUsage", 1);
                List<UsageDiscipline> usageDisciplineToutesPourId = query.getResultList();
                List<Usage> listeUsage = new ArrayList<>();
                for(int i = 0; i<usageDisciplineToutesPourId.size(); ++i) {
                    TypedQuery<Usage> query2 = em.createNamedQuery("Usage.findById", Usage.class);
                    query2.setParameter("id", usageDisciplineToutesPourId.get(i).getIdUsage());
                    Usage usage = query2.getResultList().get(0);
                    listeUsage.add(usage);

                }







                System.out.println(listeUsage);
            }
        }
       // List<UsageAcademie> essai = new ArrayList<>();


   }

}