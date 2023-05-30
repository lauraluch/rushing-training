package com.example.rushingtraining.entities;

import com.example.rushingtraining.entities.utils.CPF;
import com.example.rushingtraining.enums.Estado;

import java.time.LocalDate;

public class Aluno {
    private String matricula;
    private final int hashSenha;
    private String nome;
    private final CPF cpf;
    private String telefone;
    private LocalDate dataNasc;
    private float peso;
    private float altura;
    private Estado estadoAluno;

    public Aluno(String matricula, int hashSenha, String nome, CPF cpf,
                 String telefone, LocalDate dataNasc, float peso, float altura, Estado estadoAluno) {
        this.matricula = matricula;
        this.hashSenha = hashSenha;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.peso = peso;
        this.altura = altura;
        this.estadoAluno = estadoAluno;
    }

    public Aluno(int hashSenha, CPF cpf) {
        this.hashSenha = hashSenha;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Estado getEstadoAluno() {
        return estadoAluno;
    }

    public void setEstadoAluno(Estado estadoAluno) {
        this.estadoAluno = estadoAluno;
    }
}
