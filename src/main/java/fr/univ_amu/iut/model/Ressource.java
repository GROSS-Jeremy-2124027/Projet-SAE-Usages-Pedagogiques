package fr.univ_amu.iut.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.net.URL;
import java.util.Objects;

@Entity
public class Ressource {
    @Id
    @GeneratedValue
    int id;
    @ManyToOne
    TypeRessource typeRessource;
    URL lienRessource;

    public Ressource(TypeRessource typeRessource, URL lienRessource) {
        this.typeRessource = typeRessource;
        this.lienRessource = lienRessource;
    }

    public Ressource() {
    }

    public TypeRessource getTypeRessource() {
        return typeRessource;
    }

    public URL getLienRessource() {
        return lienRessource;
    }

    @Override
    public String toString() {
        return "Ressource{" +
                "id=" + id +
                ", typeRessource=" + typeRessource +
                ", lienRessource=" + lienRessource +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ressource ressource = (Ressource) o;
        return id == ressource.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
