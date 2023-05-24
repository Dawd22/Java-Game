package com.kotprog.kotprog;

import com.kotprog.kotprog.controlok.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;

import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/com/kotprog/kotprog/Menu.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Heroes of Might Magic - Duel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}