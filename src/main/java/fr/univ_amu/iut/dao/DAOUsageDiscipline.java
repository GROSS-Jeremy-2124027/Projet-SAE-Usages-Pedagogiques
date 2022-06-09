package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.UsageDiscipline;
import fr.univ_amu.iut.model.UsageThematique;

import java.util.List;

public interface DAOUsageDiscipline extends DAO<UsageDiscipline>{

    List<UsageDiscipline> findByDiscipline(int idUsage);
    List<UsageDiscipline> findAll();

}
