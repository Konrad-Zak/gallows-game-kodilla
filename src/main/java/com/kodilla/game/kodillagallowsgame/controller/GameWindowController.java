package com.kodilla.game.kodillagallowsgame.controller;

import javafx.fxml.FXML;

public class GameWindowController {
    private MainController mainController;

    @FXML
    private void endGame(){
        mainController.loadMenu();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
