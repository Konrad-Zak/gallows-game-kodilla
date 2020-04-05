package com.kodilla.game.dialog;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DialogUtils {

    public void dialogLastChance(String prompt){
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Prompt");
        informationAlert.setHeaderText(prompt);
        informationAlert.showAndWait();
    }

    public Optional<ButtonType> confirmSaveGame(){
        Alert confirmSave = new Alert(Alert.AlertType.CONFIRMATION);
        confirmSave.setTitle("Save Game");
        confirmSave.setHeaderText("Would you like to save this game?");
        Optional<ButtonType> result = confirmSave.showAndWait();
        return result;
    }
}
