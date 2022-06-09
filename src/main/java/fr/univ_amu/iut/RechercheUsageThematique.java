package fr.univ_amu.iut;

import fr.univ_amu.iut.model.Usage;
import fr.univ_amu.iut.model.UsageAcademie;
import fr.univ_amu.iut.model.UsageThematique;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class

RechercheUsageThematique {
    public static void main(String[] args) {
       /* try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageThematique> query = em.createNamedQuery("UsageThematique.findAll", UsageThematique.class);
                List<UsageThematique> usageThematiques = query.getResultList();
                System.out.println(usageThematiques);
            }
        }*/
      /*  try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageThematique> query = em.createNamedQuery("UsageThematique.findByThematique", UsageThematique.class);
                query.setParameter("nomThematique", "PHYSIQUE CHIMIE");
                List<UsageThematique> usagesThematiquePhysique = query.getResultList();
                System.out.println(usagesThematiquePhysique);


            }
        }*/

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageThematique> query = em.createNamedQuery("UsageThematique.findByThematique", UsageThematique.class);
                query.setParameter("nomThematique", "Programmation/Codage/Robotique");
                List<UsageThematique> usagesThematiqueProg = query.getResultList();
                List<Usage> listeUsage = new ArrayList<>();
                for(int i = 0; i<usagesThematiqueProg.size(); ++i) {
                    TypedQuery<Usage> query2 = em.createNamedQuery("Usage.findById", Usage.class);
                    query2.setParameter("id", usagesThematiqueProg.get(i).getIdUsage());
                    Usage usage = query2.getResultList().get(0);
                    listeUsage.add(usage);

                }




                //join artisanal
                System.out.println(listeUsage);
            }
        }
       // List<UsageAcademie> essai = new ArrayList<>();


    }

}