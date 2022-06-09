package fr.univ_amu.iut.model;

public enum Niveau {
    Tous("Tous"),
    PremierDegre("Premier degré"),
    SecondDegre("Second degré");
    final String nom;
    Niveau(String nom){
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Niveau{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
