package com.kotprog.kotprog.controlok;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class MainControl {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void single(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/kotprog/kotprog/Single.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public void exit(ActionEvent e) {
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }


}