package com.example.AnimaClub.dao;

import com.example.AnimaClub.model.Compte;

import java.sql.SQLException;
import java.util.List;

public interface CompteDAO {

    List<Compte> findAll() throws SQLException;
    Compte findByPseudo(String pseudo) throws SQLException;
    Compte findByMail(String mail) throws SQLException;
}
