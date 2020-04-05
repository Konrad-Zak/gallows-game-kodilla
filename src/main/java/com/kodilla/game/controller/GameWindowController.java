package com.kodilla.game.controller;

import com.kodilla.game.io.FileReader;
import com.kodilla.game.io.FileWriter;
import com.kodilla.game.model.GameWindowModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.util.*;

public class GameWindowController {
    private MainController mainController;
    private GameWindowModel gameWindowModel;
    private FileWriter fileWriter = new FileWriter();
    private FileReader fileReader = new FileReader();


    @FXML
    Label labelCategory;

    @FXML
    ToggleGroup gameToggleButton;

    @FXML
    ToggleButton q, w, e, r, t, y, u, i, o, p, a, s, d, f, g, h, j, k, l, z, x, c, v, b, n, m;

    @FXML
    HBox mysteriousWord;



    Map<Character,ToggleButton> hashMap = new HashMap<>();
    Map<Character,Boolean> gameKeys = new HashMap<>();
    char[] word;

    List<Button> buttons = new ArrayList<>();



    @FXML
    public void initialize(){
        initializeKeyMap();
        loadFile();
        labelCategory.setText(gameWindowModel.getNameCategory());

        word = gameWindowModel.getWordName();
        initMapWorld();

        System.out.println(hashMap.size());
    }

    private void loadFile(){
        if (fileWriter.gameStatusFileExists()){
            gameWindowModel = fileReader.readGameStatus();
            gameKeys = gameWindowModel.getGameKeys();
            for(Map.Entry<Character,Boolean> entry: gameKeys.entrySet()){
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
        //fileWriter.gameStatusWrite(gameWindowModel);
        gameWindowModel.setGameKeys(gameKeys);
        mainController.loadMenu();
    }

    private void initializeKeyMap(){
        List<ToggleButton> toggleButtons = Arrays.asList(q, w, e, r, t, y, u, i, o,
                p, a, s, d, f, g, h, j, k, l, z, x, c, v, b, n, m);

        for (ToggleButton toggleButtonList: toggleButtons){
            hashMap.put(toggleButtonList.getText().charAt(0),toggleButtonList);
        }
    }

    public void clickGameKey(){
        String result = gameToggleButton.getSelectedToggle().toString();
        char charToggleButton = result.charAt(45);
        System.out.println(charToggleButton);

        if(hashMap.containsKey(charToggleButton)){
            ToggleButton toggleButton = hashMap.get(charToggleButton);
            toggleButton.setVisible(false);
        }

        gameWindowModel.setFalseValue(charToggleButton);

        for (int i = 0; i <word.length ; i++) {
            if (word[i] == charToggleButton){
                Button button = buttons.get(i);
                button.setText(Character.toString(charToggleButton));
            }

        }


    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    private void initMapWorld(){

        for (int i = 0; i <word.length ; i++) {
            Button button = new Button();
            button.setDisable(true);
            mysteriousWord.getChildren().add(button);
            buttons.add(button);
        }
    }
}
