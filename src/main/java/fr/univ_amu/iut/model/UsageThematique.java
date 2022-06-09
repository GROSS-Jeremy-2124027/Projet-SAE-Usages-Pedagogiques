package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "UsageThematique.findAll", query = "SELECT p FROM UsageThematique p"),
        @NamedQuery(name = "UsageThematique.findByThematique", query = "SELECT p FROM UsageThematique p WHERE p.nomThematique = :nomThematique"),

})
public class UsageThematique {
    @Id
    int idUsage;

    @Id
    int idThematique;

    String nomThematique;

    public UsageThematique() {
    }

     public List<UsageThematique> listUsagesParThematique(String nomThematique){
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageThematique> query = em.createNamedQuery("UsageThematique.findByThematique", UsageThematique.class);
                query.setParameter("nomThematique", nomThematique);
                return query.getResultList();

            }
        }
    }

    public String getNomThematique() {
        return nomThematique;
    }

    public int getIdUsage() {
        return idUsage;
    }

    @Override
    public String toString() {
        return "UsageThematique{" +
                "idUsage=" + idUsage+ ", idThematique=" + idThematique +
                ", nomThematique='" + nomThematique + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsageThematique that = (UsageThematique) o;
        return (idUsage == that.idUsage & idThematique == that.idThematique  & nomThematique == that.nomThematique);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsage,idThematique,nomThematique);
    }
}
