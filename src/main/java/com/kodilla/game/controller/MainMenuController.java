package com.kodilla.game.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainMenuController {

    private String source;
    private VBox vBox;
    private MainController mainController;
    private FXMLLoader fxmlLoader = new FXMLLoader();

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void startGame(){
        source = "/fxml/GameWindow.fxml";
        switchedScreen(source);

        GameWindowController gameWindowController = fxmlLoader.getController();
        gameWindowController.setMainController(mainController);
        mainController.setScreen(vBox);
    }

    @FXML
    private void openSettings(){
        source = "/fxml/SettingsMenu.fxml";
        switchedScreen(source);

        SettingsMenuController settingsMenuController = fxmlLoader.getController();
        settingsMenuController.setMainController(mainController);
        mainController.setScreen(vBox);
    }

    @FXML
    private void exit(){
        Platform.exit();
        System.exit(0);
    }

    private void switchedScreen(String source){
        fxmlLoader.setLocation(this.getClass().getResource(source));
        vBox = new VBox();
        try {
            vBox = fxmlLoader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
