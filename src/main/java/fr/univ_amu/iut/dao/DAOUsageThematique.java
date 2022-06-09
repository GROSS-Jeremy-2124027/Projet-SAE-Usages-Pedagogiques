package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.UsageAcademie;
import fr.univ_amu.iut.model.UsageThematique;

import java.util.List;

public interface DAOUsageThematique extends DAO<UsageThematique>{

    List<UsageThematique> findByThematique(String nomThematique);
    List<UsageThematique> findAll();

}
