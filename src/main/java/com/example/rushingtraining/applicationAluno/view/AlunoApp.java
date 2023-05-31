package com.example.rushingtraining.applicationAluno.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AlunoApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Pane sceneGraph = FXMLLoader.load((getClass().getResource("applicationAluno.fxml")));
        //Group root = new Group();
        Scene scene = new Scene(sceneGraph);

        stage.setTitle("Rushing Training");
        //stage.setWidth(650);
        //stage.setHeight(650);
        //stage.setResizable(false);



        stage.setScene(scene);
        stage.show();

    }
}
