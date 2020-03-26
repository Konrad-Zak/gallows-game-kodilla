package com.kodilla.game.kodillagallowsgame.controller;

import javafx.fxml.FXML;


public class SettingsMenuController {

    private MainController mainController;

    @FXML
    private void goBack(){
        mainController.loadMenu();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
