module rushingtraining {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.rushingtraining.applicationAluno.view;
    opens com.example.rushingtraining.applicationAluno.controller;
    exports com.example.rushingtraining.applicationAluno.view;
    exports com.example.rushingtraining.applicationAluno.controller;

    opens com.example.rushingtraining.applicationFuncionario.view;
    exports com.example.rushingtraining.applicationFuncionario.view;

}