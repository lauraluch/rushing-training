package com.example.rushingtraining.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Treino {
    private String nome;
    private String descricao;
    private final Map<String, Integer> exercicios = new HashMap<>();

    public Treino(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Treino() {
    }

    @Override
    public String toString() {
        return "Treino{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", exercicios=" + exercicios +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treino treino = (Treino) o;
        return Objects.equals(nome, treino.nome) && Objects.equals(descricao, treino.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
