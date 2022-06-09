package fr.univ_amu.iut.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class TypeRessource {
    @Id
    @GeneratedValue
    int id;
    String nom;

    public TypeRessource(String nom) {
        this.nom = nom;
    }

    public TypeRessource() {}

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "TypeRessource{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeRessource that = (TypeRessource) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
