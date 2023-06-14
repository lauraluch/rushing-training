package com.example.rushingtraining.persistence.dao;

import com.example.rushingtraining.entities.Aluno;
import com.example.rushingtraining.entities.utils.CPF;
import com.example.rushingtraining.enums.Estado;
import com.example.rushingtraining.persistence.utils.AbstractSqlTemplateDAO;
import com.example.rushingtraining.persistence.utils.GenericDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AlunoDAO extends AbstractSqlTemplateDAO<Aluno, String> {

    @Override
    protected String criarSqlSave() {
        return "INSERT INTO aluno (matricula, senha, nome, cpf, telefone, dataNasc, peso, altura, estado) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String criarSqlUpdate() {
        return "UPDATE aluno SET senha = ?, nome = ?, cpf = ?, telefone = ?, dataNasc = ?, peso = ?, altura = ?, estado = ? " +
                "WHERE matricula = ?";
    }

    @Override
    protected String criarSqlDelete() {
        return "DELETE FROM aluno WHERE matricula = ?";
    }

    @Override
    protected String criarSqlSelect() {
        return "SELECT * FROM aluno WHERE matricula = ?";
    }

    @Override
    protected String criarSqlSelectAll() {
        return "SELECT * FROM aluno";
    }

    @Override
    protected void setEntidadeParaPreparedStmt(Aluno entidade, PreparedStatement stmt) throws SQLException {
        stmt.setInt(1, entidade.getHashSenha());
        stmt.setString(2, entidade.getNome());
        stmt.setString(3, entidade.getCpf().getCpfString());
        stmt.setString(4, entidade.getTelefone());
        stmt.setString(5, entidade.getDataNasc().toString());
        stmt.setDouble(6, entidade.getPeso());
        stmt.setDouble(7, entidade.getAltura());
        stmt.setString(8, entidade.getEstadoAluno().getEstado());
        stmt.setString(9, entidade.getMatricula());
    }

    @Override
    protected void setKeyParaPreparedStmt(String key, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, key);
    }

    @Override
    protected String getKeyEntidade(Aluno entidade) {
        return entidade.getMatricula();
    }

    @Override
    protected Aluno getEntidadeFromResultSet(ResultSet rs) throws SQLException {
        CPF cpf = new CPF(rs.getString("cpf"));
        Aluno aluno = new Aluno(rs.getString("matricula"), rs.getInt("senha"), cpf);

        aluno.setNome(rs.getString("nome"));
        aluno.setTelefone(rs.getString("telefone"));
        aluno.setDataNasc(LocalDate.parse(rs.getString("dataNasc")));
        aluno.setPeso((float) rs.getDouble("peso"));
        aluno.setAltura((float) rs.getDouble("altura"));
        aluno.setEstadoAluno(Estado.valueOf(rs.getString("estado")));

        return aluno;
    }
}
