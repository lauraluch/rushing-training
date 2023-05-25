module rushingtraining {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.rushingtraining.applicationAluno.view to javafx.fxml;
    exports com.example.rushingtraining.applicationAluno.view;

    opens com.example.rushingtraining.applicationFuncionario.view to javafx.fxml;
    exports com.example.rushingtraining.applicationFuncionario.view;
}