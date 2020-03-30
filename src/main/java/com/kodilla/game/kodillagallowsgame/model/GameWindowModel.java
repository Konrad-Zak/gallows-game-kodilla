package com.kodilla.game.kodillagallowsgame.model;

import java.io.Serializable;
import java.util.*;

public class GameWindowModel implements Serializable {
    private static final long serialVersionUID = 3812017177088221111L;

    private Map<String,Boolean> gameKeys;


    public GameWindowModel() {
        initializeMaps();
    }

    public void setFalseValue(String string){
        gameKeys.replace(string,false);
        System.out.println(gameKeys);
    }

    public Map<String, Boolean> getGameKeys() {
        return gameKeys;
    }

    public void setGameKeys(Map<String, Boolean> gameKeys) {
        this.gameKeys = gameKeys;
    }

    private void initializeMaps(){
        List<String> keys = Arrays.asList("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
                "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M");
        gameKeys = new HashMap<>();
        for (String key: keys){
            gameKeys.put(key,true);
        }
    }
}
