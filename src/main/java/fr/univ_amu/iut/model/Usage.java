package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
@NamedQuery(name = "Usage.findAll", query = "SELECT p FROM Usage p"),
        @NamedQuery(name = "Usage.findById", query = "SELECT p FROM Usage p WHERE p.id = :id"),

})
public class Usage {
    @Id
    @GeneratedValue
    int id;

    String nom;
    String description;

    @ManyToOne(cascade = CascadeType.ALL)
    Discipline discipline;
    @ManyToOne(cascade = CascadeType.ALL)
    Thematique thematique;

    @Enumerated(EnumType.STRING)
    Niveau niveau;

   @OneToMany(cascade = CascadeType.ALL)
    List<Academie> academies = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    List<Ressource> ressources = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    List<Acteur> acteurs = new ArrayList<>();

    String commentaire;


    public Usage() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Thematique getThematique() {
        return thematique;
    }

    public void setThematique(Thematique thematique) {
        this.thematique = thematique;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }


   public List<Academie> getAcademies() {
        return academies;
    }

    public void addAcademies(Academie ... academies) {
        this.academies.addAll(List.of(academies));
    }
    public void addAcademies(Collection<? extends Academie> academies){
        this.academies.addAll(academies);
    }

    public List<Ressource> getRessources() {
        return ressources;
    }

    public void addRessource(Ressource ressource) {
        this.ressources.add(ressource);
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void addActeur(Acteur acteur) {
        this.acteurs.add(acteur);
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "Usage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", discipline=" + discipline +
                ", thematique=" + thematique +
                ", niveau=" + niveau +
                //", academie=" + academie +
                ", ressources=" + ressources +
                ", acteurs=" + acteurs +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usage usage = (Usage) o;
        return id == usage.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
