package com.kodilla.game.kodillagallowsgame.model;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.io.Serializable;

public class SettingsMenuModel implements Serializable{

    private static final long serialVersionUID = 3812017177088226528L;

    private Boolean checkBoxSport;

    public SettingsMenuModel() {
        this.checkBoxSport = false;
    }

    public Boolean getCheckBoxSport() {
        return checkBoxSport;
    }

    public void setCheckBoxSport(Boolean checkBoxSport) {
        this.checkBoxSport = checkBoxSport;
    }
/*
    private BooleanProperty checkBoxSport = new SimpleBooleanProperty();
    private BooleanProperty checkBoxAutomotive= new SimpleBooleanProperty(true);
    private BooleanProperty checkBoxLife = new SimpleBooleanProperty(true);
    private BooleanProperty checkBoxHouse = new SimpleBooleanProperty(true);
    private BooleanProperty checkBoxGames = new SimpleBooleanProperty(true);

    private BooleanProperty radioLevelEasy = new SimpleBooleanProperty(false);
    private BooleanProperty radioLevelMedium = new SimpleBooleanProperty(true);
    private BooleanProperty radioLevelHard = new SimpleBooleanProperty(false);



    public boolean isCheckBoxSport() {
        return checkBoxSport.get();
    }

    public BooleanProperty checkBoxSportProperty() {
        return checkBoxSport;
    }

    public void setCheckBoxSport(boolean checkBoxSport) {
        this.checkBoxSport.set(checkBoxSport);
    }

    public boolean isCheckBoxAutomotive() {
        return checkBoxAutomotive.get();
    }

    public BooleanProperty checkBoxAutomotiveProperty() {
        return checkBoxAutomotive;
    }

    public void setCheckBoxAutomotive(boolean checkBoxAutomotive) {
        this.checkBoxAutomotive.set(checkBoxAutomotive);
    }

    public boolean isCheckBoxLife() {
        return checkBoxLife.get();
    }

    public BooleanProperty checkBoxLifeProperty() {
        return checkBoxLife;
    }

    public void setCheckBoxLife(boolean checkBoxLife) {
        this.checkBoxLife.set(checkBoxLife);
    }

    public boolean isCheckBoxHouse() {
        return checkBoxHouse.get();
    }

    public BooleanProperty checkBoxHouseProperty() {
        return checkBoxHouse;
    }

    public void setCheckBoxHouse(boolean checkBoxHouse) {
        this.checkBoxHouse.set(checkBoxHouse);
    }

    public boolean isCheckBoxGames() {
        return checkBoxGames.get();
    }

    public BooleanProperty checkBoxGamesProperty() {
        return checkBoxGames;
    }

    public void setCheckBoxGames(boolean checkBoxGames) {
        this.checkBoxGames.set(checkBoxGames);
    }

    public boolean isRadioLevelEasy() {
        return radioLevelEasy.get();
    }

    public BooleanProperty radioLevelEasyProperty() {
        return radioLevelEasy;
    }

    public void setRadioLevelEasy(boolean radioLevelEasy) {
        this.radioLevelEasy.set(radioLevelEasy);
    }

    public boolean isRadioLevelMedium() {
        return radioLevelMedium.get();
    }

    public BooleanProperty radioLevelMediumProperty() {
        return radioLevelMedium;
    }

    public void setRadioLevelMedium(boolean radioLevelMedium) {
        this.radioLevelMedium.set(radioLevelMedium);
    }

    public boolean isRadioLevelHard() {
        return radioLevelHard.get();
    }

    public BooleanProperty radioLevelHardProperty() {
        return radioLevelHard;
    }

    public void setRadioLevelHard(boolean radioLevelHard) {
        this.radioLevelHard.set(radioLevelHard);
    } */
}
