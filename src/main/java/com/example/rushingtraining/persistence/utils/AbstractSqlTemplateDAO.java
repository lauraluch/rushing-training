package com.example.rushingtraining.persistence.utils;

import com.example.rushingtraining.persistence.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractSqlTemplateDAO <T, K> implements GenericDAO <T, K>{
    protected abstract String criarSqlSave();
    protected abstract String criarSqlUpdate();
    protected abstract String criarSqlDelete();
    protected abstract String criarSqlSelect();
    protected abstract String criarSqlSelectAll();

    protected abstract void setEntidadeParaPreparedStmt(T entidade, PreparedStatement stmt) throws SQLException;
    protected abstract void setKeyParaPreparedStmt(K key, PreparedStatement stmt) throws SQLException;
    protected abstract K getKeyEntidade(T entidade);
    protected abstract T getEntidadeFromResultSet(ResultSet rs) throws SQLException;
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

    @Override
    public List<T> selectAll(){
        sql = criarSqlSelectAll();
        return getListaEntidades();
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

    private List<T> getListaEntidades() {
        List<T> listEntidades = new ArrayList<>();

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                T entidade = getEntidadeFromResultSet(rs);
                listEntidades.add(entidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listEntidades;
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
