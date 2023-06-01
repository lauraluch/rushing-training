package com.example.rushingtraining;

import com.example.rushingtraining.entities.Exercicio;
import com.example.rushingtraining.entities.GrupoTreino;

import javax.crypto.spec.PSource;

public class PrincipalTest {
    public static void main(String[] args) {
        Exercicio ex1 = new Exercicio("nome", "banco", "3x12", "imagem");
        Exercicio ex2 = new Exercicio("nome", "banco", "3x12", "imagem");
        Exercicio ex3 = new Exercicio("nome2", "banco", "3x12", "imagem");
        System.out.println(ex1.getId());
        System.out.println(ex2.getId());
        System.out.println(ex3.getId());

        /*GrupoTreino gp = new GrupoTreino("gp1");
        System.out.println(gp.getId());
        gp.addExercicio(ex1);
        System.out.println(gp.getId());*/
    }

}
