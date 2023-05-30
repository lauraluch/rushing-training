package com.example.rushingtraining.entities;

import java.util.Objects;

public class Exercicio {
    private String nome;
    private String aparelhoNecessario;

    private String repeticoesEsperadas;
    private String pathImagemAparelho;

    public Exercicio(String nome, String aparelhoNecessario, String repeticoesEsperadas, String pathImagemAparelho) {
        this.nome = nome;
        this.aparelhoNecessario = aparelhoNecessario;
        this.repeticoesEsperadas = repeticoesEsperadas;
        this.pathImagemAparelho = pathImagemAparelho;
    }

    @Override
    public String toString() {
        return "Exercicio: " + nome +
                "\nAparelho Necessario: " + aparelhoNecessario +
                "\nRepetições Esperadas: " + repeticoesEsperadas;
    }

    public Exercicio() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRepeticoesEsperadas() {
        return repeticoesEsperadas;
    }

    public void setRepeticoesEsperadas(String repeticoesEsperadas) {
        this.repeticoesEsperadas = repeticoesEsperadas;
    }

    public String getAparelhoNecessario() {
        return aparelhoNecessario;
    }

    public void setAparelhoNecessario(String aparelhoUtilizado) {
        this.aparelhoNecessario = aparelhoUtilizado;
    }

    public String getPathImagemAparelho() {
        return pathImagemAparelho;
    }

    public void setPathImagemAparelho(String pathImagemAparelho) {
        this.pathImagemAparelho = pathImagemAparelho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercicio exercicio = (Exercicio) o;
        return Objects.equals(nome, exercicio.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
