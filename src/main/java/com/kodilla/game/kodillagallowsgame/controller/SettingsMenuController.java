package com.kodilla.game.kodillagallowsgame.controller;

import com.kodilla.game.kodillagallowsgame.io.FileCreator;
import com.kodilla.game.kodillagallowsgame.io.FileReader;
import com.kodilla.game.kodillagallowsgame.io.FileWriter;
import com.kodilla.game.kodillagallowsgame.model.SettingsMenuModel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;



public class SettingsMenuController {

    private MainController mainController;
    private FileCreator fileCreator = new FileCreator();
    private FileWriter fileWriter = new FileWriter();
    private FileReader fileReader = new FileReader();
    private SettingsMenuModel settingsMenuModel;

    @FXML
    CheckBox buttonSport;

    @FXML
    CheckBox buttonAutomotive;

    @FXML
    CheckBox buttonLife;

    @FXML
    CheckBox buttonHouse;

    @FXML
    CheckBox buttonGames;

    @FXML
    RadioButton buttonEasy;

    @FXML
    RadioButton buttonMedium;

    @FXML
    RadioButton buttonHard;

    @FXML
    private void goBack(){

        //fileCreator.createSettingsFile();
        fileWriter.settingsWrite(settingsMenuModel);
        mainController.loadMenu();
    }

    @FXML
    public void initialize(){
        System.out.println(fileCreator.settingsFileExists());
        if (fileCreator.settingsFileExists()){
            settingsMenuModel = fileReader.readSettingsModel();
            System.out.println("sport "+settingsMenuModel.getCheckBoxSport());
        } else {
            settingsMenuModel = new SettingsMenuModel();
        }
        buttonSport.setSelected(settingsMenuModel.getCheckBoxSport());
            //category button
            buttonSport.setOnAction(event -> {
                if (buttonSport.isSelected()) {
                    settingsMenuModel.setCheckBoxSport(true);
                } else {
                    settingsMenuModel.setCheckBoxSport(false);
                }
                System.out.println(settingsMenuModel.getCheckBoxSport());
            });

       // buttonAutomotive.selectedProperty().bindBidirectional(settingsMenuModel.checkBoxAutomotiveProperty());
      //  buttonLife.selectedProperty().bindBidirectional(settingsMenuModel.checkBoxLifeProperty());
      //  buttonHouse.selectedProperty().bindBidirectional(settingsMenuModel.checkBoxHouseProperty());
      //  buttonGames.selectedProperty().bindBidirectional(settingsMenuModel.checkBoxGamesProperty());

        //level game button
       // buttonEasy.selectedProperty().bindBidirectional(settingsMenuModel.radioLevelEasyProperty());
       // buttonMedium.selectedProperty().bindBidirectional(settingsMenuModel.radioLevelMediumProperty());
       // buttonHard.selectedProperty().bindBidirectional(settingsMenuModel.radioLevelHardProperty());
    }

    @FXML
    public void click(){
      //  System.out.println("easy: "+ settingsMenuModel.radioLevelEasyProperty());
      //  System.out.println("medium: "+ settingsMenuModel.isRadioLevelMedium());
      //  System.out.println("hard: " + settingsMenuModel.isRadioLevelHard());
    }

    public void clickSport(){
      //  buttonSport.selectedProperty().bindBidirectional(settingsMenuModel.checkBoxSportProperty());
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
