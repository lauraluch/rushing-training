package com.example.rushingtraining.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBuilder {
    public static void main(String[] args) throws SQLException, IOException {
        dropDatabaseIfExists();
        createTables();
        System.out.println("\nAll set =)");
    }

    private static void dropDatabaseIfExists() throws IOException {
        final Path path = Paths.get("database.db");
        if(Files.exists(path)) {
            Files.delete(path);
            System.out.println("Deleting existing database...");
        }
    }

    private static void createTables() throws SQLException{
        createTableAluno();
        createTableExercicio();
        createTableFuncionario();
    }

    private static void createTableAluno() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement stmt = connection.createStatement();
        String sql = """
                CREATE TABLE aluno(
                    matricula TEXT NOT NULL PRIMARY KEY,
                    senha INTEGER NOT NULL,
                    nome TEXT NOT NULL,
                    cpf TEXT NOT NULL,
                    telefone TEXT,
                    dataNasc TEXT,
                    peso REAL,
                    altura REAL,
                    estado TEXT
                )
                """;
        System.out.println("Creating table: \n \n" + sql);
        stmt.executeUpdate(sql);
        stmt.close();
        connection.close();
    }

    private static void createTableExercicio() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement stmt = connection.createStatement();
        String sql = """
                CREATE TABLE exercicio(
                    id INTEGER NOT NULL PRIMARY KEY,
                    nome TEXT NOT NULL,
                    aparelhoNecessario TEXT NOT NULL,
                    repeticoesEsperadas INTEGER NOT NULL
                )
                """;
        System.out.println("Creating table: \n \n" + sql);
        stmt.executeUpdate(sql);
        stmt.close();
        connection.close();
    }

    private static void createTableFuncionario() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement stmt = connection.createStatement();
        String sql = """
                CREATE TABLE funcionario(
                    cpf TEXT NOT NULL PRIMARY KEY,
                    senha INTEGER NOT NULL,
                    nome TEXT NOT NULL,
                    telefones TEXT,
                    email TEXT,
                    cargo TEXT NOT NULL,
                    estado TEXT NOT NULL
                )
                """;
        System.out.println("Creating table: \n \n" + sql);
        stmt.executeUpdate(sql);
        stmt.close();
        connection.close();
    }
}
