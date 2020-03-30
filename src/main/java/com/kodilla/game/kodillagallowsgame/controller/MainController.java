package com.kodilla.game.kodillagallowsgame.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {

    public VBox mainScreen;

    public void loadMenu(){
        MainMenuController mainMenuController;
        VBox vBox;

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource("/fxml/MainMenu.fxml"));

        try {
            vBox = fxmlLoader.load();
        } catch (IOException e){
            vBox = new VBox();
            e.printStackTrace();
        }
        mainMenuController = fxmlLoader.getController();
        mainMenuController.setMainController(this);
        setScreen(vBox);
    }

    public void setScreen(VBox vBox){
        mainScreen.getChildren().clear();
        mainScreen.getChildren().add(vBox);
    }

    @FXML
    private void initialize(){
        loadMenu();
    }

}
