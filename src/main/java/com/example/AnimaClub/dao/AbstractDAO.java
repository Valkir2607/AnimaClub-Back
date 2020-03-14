package com.example.AnimaClub.dao;

import java.sql.Connection;
import java.sql.SQLException;

import static com.example.AnimaClub.dao.ConnectionProvider.provide;

public abstract class AbstractDAO<T> {

    protected Connection connection;

    public AbstractDAO() throws SQLException{
        this.connection = provide();
    }

    public abstract void create(T obj) throws SQLException;
    public abstract boolean delete(T obj) throws SQLException;
    public abstract void update(T obj) throws SQLException;
    public abstract T find(int id) throws SQLException;
}