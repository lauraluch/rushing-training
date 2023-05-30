package com.example.rushingtraining.enums;

public enum Cargo {
    PROFESSOR("Professor"),
    ADMIN("Administrador");

    private final String funcao;

    Cargo(String funcao) {
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }
}
