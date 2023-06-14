package com.example.rushingtraining;

import com.example.rushingtraining.entities.Aluno;
import com.example.rushingtraining.entities.Exercicio;
import com.example.rushingtraining.entities.utils.CPF;
import com.example.rushingtraining.enums.Estado;
import com.example.rushingtraining.persistence.dao.AlunoDAO;

import java.time.LocalDate;

public class PrincipalTest {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        CPF cpf = new CPF("123.456.789-00");
        Aluno aluno = new Aluno("MATRICULA01", 123, "Laura Chiquetano", cpf, "(16) 992993456", LocalDate.now(),
                50, 180, Estado.ATIVO);

        alunoDAO.save(aluno);
        System.out.println(alunoDAO.select("MATRICULA01").toString());
    }

}
