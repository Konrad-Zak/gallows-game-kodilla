package com.kodilla.game.dialog;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DialogUtils {

    public void informationDialog(String title,String header){
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(title);
        informationAlert.setHeaderText(header);
        informationAlert.showAndWait();
    }

    public Optional<ButtonType> confirmDialog(String title, String header){
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle(title);
        confirmAlert.setHeaderText(header);
        return confirmAlert.showAndWait();
    }


}
