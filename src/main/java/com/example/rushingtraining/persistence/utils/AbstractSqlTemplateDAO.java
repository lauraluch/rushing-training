package com.example.rushingtraining.persistence.utils;

import com.example.rushingtraining.persistence.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public abstract class AbstractSqlTemplateDAO <T, K> implements GenericDAO <T, K>{

    /* TODO: Criar a função de select e select all
            Select
            - Criar query
            - Pegar result set da entidade e verificar se ele é válido
            - Se for, pegar as informações e retornar objeto
            - Sen retornar optional (n sei como funfa direito)*/

    protected abstract String criarSqlSave();
    protected abstract String criarSqlUpdate();
    protected abstract String criarSqlDelete();
    protected abstract String criarSqlSelect();

    protected abstract void setEntidadeParaPreparedStmt(T entidade, PreparedStatement stmt) throws SQLException;
    protected abstract void setKeyParaPreparedStmt(K key, PreparedStatement stmt) throws SQLException;
    protected abstract K getKeyEntidade(T entidade);
    protected abstract T getEntidadeFromResultSet(ResultSet rs);
    private String sql;

    @Override
    public void save(T entidade){
        sql = criarSqlSave();
        executarSqlViaEntidate(entidade);
    }

    @Override
    public void update(T entidade){
        sql = criarSqlUpdate();
        executarSqlViaEntidate(entidade);
    }

    @Override
    public void saveOrUpdate(T entidade){
        Optional<T> res = select(getKeyEntidade(entidade));
        if(res.isPresent()){
            update(entidade);
        }
        else {
            save(entidade);
        }
    }

    @Override
    public void delete(K key){
        sql = criarSqlDelete();
        executarSqlViaKey(key);
    }

    @Override
    public Optional<T> select(K key){
        sql = criarSqlSelect();
        return getEntidadeSelect(key);
    }

    private void executarSqlViaKey(K key) {
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            setKeyParaPreparedStmt(key, stmt);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Optional<T> getEntidadeSelect(K key) {
        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            setKeyParaPreparedStmt(key, stmt);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(getEntidadeFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }


    private void executarSqlViaEntidate(T entidade){
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            setEntidadeParaPreparedStmt(entidade, stmt);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
