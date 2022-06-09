package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.Usage;

import java.util.List;

public interface DAOUsage extends DAO<Usage>{

    List<Usage> findById(int id);
    List<Usage> findAll();

}
