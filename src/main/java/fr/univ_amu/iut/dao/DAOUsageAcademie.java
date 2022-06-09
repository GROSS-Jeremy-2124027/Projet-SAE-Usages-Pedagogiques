package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.Usage;
import fr.univ_amu.iut.model.UsageAcademie;

import java.util.List;

public interface DAOUsageAcademie extends DAO<UsageAcademie>{

    List<UsageAcademie> findByAcademie(String nomAcademie);
    List<UsageAcademie> findAll();

}
