package com.kodilla.game.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class SettingsMenuModel implements Serializable{

    private static final long serialVersionUID = 3812017177088226528L;

    private Boolean checkBoxSport;
    private Boolean checkBoxAutomotive;
    private Boolean checkBoxLife;
    private Boolean checkBoxHouse;
    private Boolean checkBoxGames;

    private Boolean radioButtonEasy;
    private Boolean radioButtonMedium;
    private Boolean radioButtonHard;



    public SettingsMenuModel() {
        this.checkBoxSport = true;
        this.checkBoxAutomotive = true;
        this.checkBoxLife = true;
        this.checkBoxHouse = true;
        this.checkBoxGames = true;
        this.radioButtonEasy = false;
        this.radioButtonMedium = true;
        this.radioButtonHard =  false;
    }

    public Boolean getRadioButtonEasy() {
        return radioButtonEasy;
    }

    public void setRadioButtonEasy(Boolean radioButtonEasy) {
        this.radioButtonEasy = radioButtonEasy;
    }

    public Boolean getRadioButtonMedium() {
        return radioButtonMedium;
    }

    public void setRadioButtonMedium(Boolean radioButtonMedium) {
        this.radioButtonMedium = radioButtonMedium;
    }

    public Boolean getRadioButtonHard() {
        return radioButtonHard;
    }

    public void setRadioButtonHard(Boolean radioButtonHard) {
        this.radioButtonHard = radioButtonHard;
    }

    public Boolean getCheckBoxSport() {
        return checkBoxSport;
    }

    public void setCheckBoxSport(Boolean checkBoxSport) {
        this.checkBoxSport = checkBoxSport;
    }

    public Boolean getCheckBoxAutomotive() {
        return checkBoxAutomotive;
    }

    public void setCheckBoxAutomotive(Boolean checkBoxAutomotive) {
        this.checkBoxAutomotive = checkBoxAutomotive;
    }

    public Boolean getCheckBoxLife() {
        return checkBoxLife;
    }

    public void setCheckBoxLife(Boolean checkBoxLife) {
        this.checkBoxLife = checkBoxLife;
    }

    public Boolean getCheckBoxHouse() {
        return checkBoxHouse;
    }

    public void setCheckBoxHouse(Boolean checkBoxHouse) {
        this.checkBoxHouse = checkBoxHouse;
    }

    public Boolean getCheckBoxGames() {
        return checkBoxGames;
    }

    public void setCheckBoxGames(Boolean checkBoxGames) {
        this.checkBoxGames = checkBoxGames;
    }

    public Map<String,Boolean> getCheckBoxMap(){
        Map<String,Boolean> map = new HashMap<>();
        map.put("Sport",checkBoxSport);
        map.put("Automotive",checkBoxAutomotive);
        map.put("House",checkBoxHouse);
        map.put("Life",checkBoxLife);
        map.put("Games",checkBoxGames);
        return map;
    }
}
