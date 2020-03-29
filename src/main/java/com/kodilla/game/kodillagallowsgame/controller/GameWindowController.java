package com.kodilla.game.kodillagallowsgame.controller;

import com.kodilla.game.kodillagallowsgame.data.CategoryList;
import com.kodilla.game.kodillagallowsgame.io.FileReader;
import com.kodilla.game.kodillagallowsgame.io.FileWriter;
import com.kodilla.game.kodillagallowsgame.model.GameWindowModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.util.*;

public class GameWindowController {
    private MainController mainController;
    private CategoryList categoryList = new CategoryList();
    GameWindowModel gameWindowModel;
    FileWriter fileWriter = new FileWriter();
    FileReader fileReader = new FileReader();


    @FXML
    Label labelCategory;

    @FXML
    ToggleGroup gameToggleButton;

    @FXML
    ToggleButton q, w, e, r, t, y, u, i, o, p, a, s, d, f, g, h, j, k, l, z, x, c, v, b, n, m;

    @FXML
    HBox mysteriousWord;



    Map<String,ToggleButton> hashMap = new HashMap<>();

    Map<String,Boolean> gameKeys = new HashMap<>();


    @FXML
    public void initialize(){
        initializeKeyMap();
        loadFile();
        labelCategory.setText(categoryList.getName());



        System.out.println(hashMap.size());
    }

    private void loadFile(){
        if (fileWriter.gameStatusFileExists()){
            gameWindowModel = fileReader.readGameStatus();
            gameKeys = gameWindowModel.getGameKeys();
            for(Map.Entry<String,Boolean> entry: gameKeys.entrySet()){
                if(!entry.getValue()){
                    ToggleButton toggleButton = hashMap.get(entry.getKey());
                    toggleButton.setVisible(false);
                }
            }
        } else {
            gameWindowModel = new GameWindowModel();
        }
    }

    @FXML
    private void endGame(){
        fileWriter.gameStatusWrite(gameWindowModel);
        gameWindowModel.setGameKeys(gameKeys);
        mainController.loadMenu();
    }

    private void initializeKeyMap(){
        List<ToggleButton> toggleButtons = Arrays.asList(q, w, e, r, t, y, u, i, o,
                p, a, s, d, f, g, h, j, k, l, z, x, c, v, b, n, m);

        for (ToggleButton toggleButtonList: toggleButtons){
            hashMap.put(toggleButtonList.getText(),toggleButtonList);
        }
    }

    public void clickGameKey(){
        String result = gameToggleButton.getSelectedToggle().toString();
        Character kas = result.charAt(45);
        System.out.println(kas);
        String my = kas.toString();

        if(hashMap.containsKey(my)){
            ToggleButton toggleButton = hashMap.get(my);
            toggleButton.setVisible(false);
        }
        //hashMap.remove(my);
        gameWindowModel.setFalseValue(my);


       // buttons.setText(my);
       // RadioButton radioButton = hashMap.get(my);
       // radioButton.setDisable(true);




    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
