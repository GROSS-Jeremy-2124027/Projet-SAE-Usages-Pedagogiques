package fr.univ_amu.iut;

import fr.univ_amu.iut.model.Discipline;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RechercheDiscipline {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")){
            try(EntityManager em = emf.createEntityManager()){
                TypedQuery<Discipline> query = em.createNamedQuery("Discipline.findAll", Discipline.class);
                //query.setParameter("annee",1);
                List <Discipline> disciplines = query.getResultList();
                System.out.println(disciplines.get(0));
            }
        }
    }
}
