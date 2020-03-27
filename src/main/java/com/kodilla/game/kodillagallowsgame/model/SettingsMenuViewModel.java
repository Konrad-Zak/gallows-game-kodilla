package com.kodilla.game.kodillagallowsgame.model;

import com.kodilla.game.kodillagallowsgame.controller.SettingsMenuController;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class SettingsMenuViewModel {

    private SettingsMenuModel settingsMenuModel;

    private BooleanProperty checkBoxSport;

    public SettingsMenuViewModel(SettingsMenuModel settingsMenuModel) {
        this.settingsMenuModel = settingsMenuModel;
        this.checkBoxSport  = new SimpleBooleanProperty(settingsMenuModel.getCheckBoxSport());
    }

    public boolean isCheckBoxSport() {
        return checkBoxSport.get();
    }

    public BooleanProperty checkBoxSportProperty() {
        return checkBoxSport;
    }

    public void setCheckBoxSport(boolean checkBoxSport) {
        this.checkBoxSport.set(checkBoxSport);
    }

    private void getSport(){
        setCheckBoxSport(settingsMenuModel.getCheckBoxSport());
    }
}
