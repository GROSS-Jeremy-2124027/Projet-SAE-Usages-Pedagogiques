package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.Discipline;

import java.util.List;

public interface DAODiscipline extends DAO<DAODiscipline>{
    List<Discipline> findByNom(String nom);

}
