package com.example.rushingtraining.persistence.utils;

import com.example.rushingtraining.persistence.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractSqlTemplateDAO <T, K> implements GenericDAO <T, K>{

    protected abstract String criarSqlSave();
    protected abstract String criarSqlUpdate();

    protected abstract void setEntidadeParaPreparedStmt(T entidade, PreparedStatement stmt) throws SQLException;
    protected abstract K getEntidadeKey(T entidade);
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
        Optional<T> res = select(getEntidadeKey(entidade));
        if(res.isPresent()){
            update(entidade);
        }
        else {
            save(entidade);
        }
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
