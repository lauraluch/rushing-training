package com.example.rushingtraining.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GrupoTreino {

    private String nome;
    private final List<Exercicio> listaExercicios = new ArrayList<>();

    public GrupoTreino(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoTreino that = (GrupoTreino) o;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "GrupoTreino{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Exercicio> getListaExercicios() {
        return listaExercicios;
    }
}
