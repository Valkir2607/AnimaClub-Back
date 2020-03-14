package com.example.AnimaClub.factory;

import com.example.AnimaClub.model.Compte;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompteFactory {

    public Compte createForm(ResultSet resultSet) throws SQLException{
        return new Compte(
            resultSet.getInt("id"),
            resultSet.getString("pseudo"),
            resultSet.getString("mail"),
            resultSet.getString("password")
        );
    }
}
