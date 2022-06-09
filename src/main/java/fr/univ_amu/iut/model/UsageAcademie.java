package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
@Entity
@NamedQueries({
        @NamedQuery(name = "UsageAcademie.findAll", query = "SELECT p FROM UsageAcademie p"),
        @NamedQuery(name = "UsageAcademie.findByAcademie", query = "SELECT p FROM UsageAcademie p WHERE p.nomAcademie = :nomAcademie"),

})
public class UsageAcademie {
    @Id
    int idUsage;
    @Id
    String codeAcademie;
    String nomAcademie;
    public UsageAcademie() {
    }

     public List<UsageAcademie> listUsagesParAcademie (String codeAca){
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageAcademie> query = em.createNamedQuery("UsageAcademie.findByAcademie", UsageAcademie.class);
                query.setParameter("codeAcademie", codeAca);
                return query.getResultList();

            }
        }
    }

    public String getCodeAcademie() {
        return codeAcademie;
    }

    public int getIdUsage() {
        return idUsage;
    }
    @Override
    public String toString() {
        return "UsageAcademie{" +
                "idUSage=" + idUsage +
                ", codeAcademie='" + codeAcademie + ",nomACademie"+ nomAcademie +'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsageAcademie that = (UsageAcademie) o;
        return idUsage == that.idUsage & nomAcademie == that.nomAcademie & codeAcademie == that.getCodeAcademie();
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsage,codeAcademie,nomAcademie);
    }
}
