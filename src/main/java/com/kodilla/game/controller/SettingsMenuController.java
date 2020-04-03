package com.kodilla.game.controller;

import com.kodilla.game.io.FileReader;
import com.kodilla.game.io.FileWriter;
import com.kodilla.game.model.SettingsMenuModel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;


public class SettingsMenuController {

    private MainController mainController;
    private SettingsMenuModel settingsMenuModel;

    private FileWriter fileWriter = new FileWriter();
    private FileReader fileReader = new FileReader();

    @FXML
    CheckBox checkBoxSport;

    @FXML
    CheckBox checkBoxAutomotive;

    @FXML
    CheckBox checkBoxLife;

    @FXML
    CheckBox checkBoxHouse;

    @FXML
    CheckBox checkBoxGames;

    @FXML
    RadioButton radioButtonEasy;

    @FXML
    RadioButton radioButtonMedium;

    @FXML
    RadioButton radioButtonHard;

    @FXML
    ToggleGroup levelChoice;

    @FXML
    public void initialize(){
        loadFile();
        setControllerValue();
    }

    @FXML
    public void clickLevelChoice(){
        settingsMenuModel.setRadioButtonEasy(radioButtonEasy.isSelected());
        settingsMenuModel.setRadioButtonMedium(radioButtonMedium.isSelected());
        settingsMenuModel.setRadioButtonHard(radioButtonHard.isSelected());
    }

    public void clickCheckBoxSport(){
        settingsMenuModel.setCheckBoxSport(checkBoxSport.isSelected());
    }

    public void clickCheckBoxAutomotive(){
        settingsMenuModel.setCheckBoxAutomotive(checkBoxAutomotive.isSelected());
    }

    public void clickCheckBoxLife(){
        settingsMenuModel.setCheckBoxLife(checkBoxLife.isSelected());
    }

    public void clickCheckBoxHouse(){
        settingsMenuModel.setCheckBoxHouse(checkBoxHouse.isSelected());
    }

    public void clickCheckBoxGames(){
        settingsMenuModel.setCheckBoxGames(checkBoxGames.isSelected());
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void goBack(){
        fileWriter.settingsWrite(settingsMenuModel);
        mainController.loadMenu();
    }

    private void loadFile(){
        if (fileWriter.settingsFileExists()){
            settingsMenuModel = fileReader.readSettingsModel();
        } else {
            settingsMenuModel = new SettingsMenuModel();
        }
    }

    private void setControllerValue(){
        checkBoxSport.setSelected(settingsMenuModel.getCheckBoxSport());
        checkBoxAutomotive.setSelected(settingsMenuModel.getCheckBoxAutomotive());
        checkBoxLife.setSelected(settingsMenuModel.getCheckBoxLife());
        checkBoxHouse.setSelected(settingsMenuModel.getCheckBoxHouse());
        checkBoxGames.setSelected(settingsMenuModel.getCheckBoxGames());
        radioButtonEasy.setSelected(settingsMenuModel.getRadioButtonEasy());
        radioButtonMedium.setSelected(settingsMenuModel.getRadioButtonMedium());
        radioButtonHard.setSelected(settingsMenuModel.getRadioButtonHard());
    }
}
