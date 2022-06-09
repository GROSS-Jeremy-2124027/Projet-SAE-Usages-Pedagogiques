package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "UsageDiscipline.findAll", query = "SELECT p FROM UsageDiscipline p"),
        @NamedQuery(name = "UsageDiscipline.findByDiscipline", query = "SELECT p FROM UsageDiscipline p WHERE p.idUsage = :idUsage"),

})
public class UsageDiscipline {
    @Id
    int idUsage;

    @Id
    int idDiscipline;

    String nomDiscipline;

    public UsageDiscipline() {
    }

     public List<UsageDiscipline> listUsagesParDiscipline(int idDiscipline){
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageDiscipline> query = em.createNamedQuery("UsageDiscipline.findByDiscipline", UsageDiscipline.class);
                query.setParameter("id", idDiscipline);
                return query.getResultList();

            }
        }
    }

    public String getNomDiscipline() {
        return nomDiscipline;
    }

    public int getIdUsage() {
        return idUsage;
    }

    @Override
    public String toString() {
        return "UsageDiscipline{" +
                "idUsage=" + idUsage+ ", idDiscipline=" + idDiscipline +
                ", nomDiscipline='" + nomDiscipline + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsageDiscipline that = (UsageDiscipline) o;
        return (idUsage == that.idUsage & idDiscipline == that.idDiscipline  & nomDiscipline == that.nomDiscipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsage,idDiscipline,nomDiscipline);
    }
}
