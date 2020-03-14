package com.example.AnimaClub.dao.impl;

import com.example.AnimaClub.dao.AbstractDAO;
import com.example.AnimaClub.dao.CompteDAO;
import com.example.AnimaClub.factory.CompteFactory;
import com.example.AnimaClub.model.Compte;
import com.example.AnimaClub.services.CompteService;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompteDAOimpl extends AbstractDAO<Compte> implements CompteDAO {

    private PreparedStatement createStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement findStatementByAll;
    private PreparedStatement findStatementById;
    private PreparedStatement findStatementByPseudo;
    private PreparedStatement findStatementByMail;
    private CompteFactory compteFactory;

    public CompteDAOimpl() throws SQLException{
        compteFactory = new CompteFactory();
    }

    @Override
    public void create(Compte compte) throws SQLException {
        if (createStatement == null){
            createStatement = this.connection.prepareStatement("INSERT INTO Compte(pseudo,mail,password) VALUES (?,?,?);");
        }
        createStatement.setString(1,compte.getPseudo());
        createStatement.setString(2,compte.getMail());
        createStatement.setString(3,compte.getPassword());

        createStatement.executeUpdate();
    }

    @Override
    public boolean delete(Compte compte) throws SQLException {
        if (deleteStatement == null) {
            deleteStatement = this.connection.prepareStatement("DELETE FROM compte WHERE id=?;");
        }
        deleteStatement.setInt(1,compte.getId());

        deleteStatement.executeUpdate();

        return true;
    }

    @Override
    public void update(Compte compte) throws SQLException {

        if (updateStatement == null) {
            updateStatement = this.connection.prepareStatement("UPDATE compte SET pseudo=?,mail=?,password=?;");
        }
        updateStatement.setString(1,compte.getPseudo());
        updateStatement.setString(2,compte.getMail());
        updateStatement.setString(3,compte.getPassword());
    }

    @Override
    public List<Compte> findAll() throws SQLException{
        if (findStatementByAll == null) {
            findStatementByAll = this.connection.prepareStatement("SELECT * from compte;");
        }
        findStatementByAll.execute();
        ResultSet resultSet = findStatementByAll.getResultSet();
        List<Compte> comptes = new ArrayList<>();
        while (resultSet.next()){
            comptes.add(compteFactory.createForm(resultSet));
        }
        return comptes;
    }

    @Override
    public Compte find(int id) throws SQLException {
        if (findStatementById == null) {
            findStatementById = this.connection.prepareStatement("SELECT * FROM compte WHERE id=?;");
        }
        findStatementById.setInt(1,id);
        ResultSet resultSet = findStatementById.executeQuery();
        if (resultSet.next()){
            return compteFactory.createForm(resultSet);
        }
        return null;
    }

    @Override
    public Compte findByPseudo(String pseudo) throws SQLException {
        if (findStatementByPseudo == null) {
            findStatementByPseudo = this.connection.prepareStatement("SELECT * FROM compte WHERE pseudo=?;");
        }
        findStatementByPseudo.setString(1,pseudo);
        ResultSet resultSet = findStatementByPseudo.executeQuery();
        if (resultSet.next()) {
            return compteFactory.createForm(resultSet);
        }
        return null;
    }

    @Override
    public Compte findByMail(String mail) throws SQLException {
        if (findStatementByMail == null) {
            findStatementByMail = this.connection.prepareStatement("SELECT * FROM compte WHERE mail=?;");
        }
        findStatementByMail.setString(1,mail);
        ResultSet resultSet = findStatementByMail.executeQuery();
        if (resultSet.next()) {
            return compteFactory.createForm(resultSet);
        }
        return null;
    }
}
