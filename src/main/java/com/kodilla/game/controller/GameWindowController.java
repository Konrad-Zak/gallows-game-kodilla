package com.kodilla.game.controller;

import com.kodilla.game.data.ImageList;
import com.kodilla.game.io.FileReader;
import com.kodilla.game.io.FileWriter;
import com.kodilla.game.model.GameWindowModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.*;

public class GameWindowController {

    private MainController mainController;
    private GameWindowModel gameWindowModel;
    private Queue<Image> imageQueue;
    private char[] word;
    private String prompt;

    private FileWriter fileWriter = new FileWriter();
    private FileReader fileReader = new FileReader();
    private Map<Character,ToggleButton> hashMap = new HashMap<>();
    private List<Button> buttons = new ArrayList<>();
    private ImageList imageList = new ImageList();

    @FXML
    Label labelCategory;

    @FXML
    ToggleGroup gameToggleButton;

    @FXML
    ToggleButton q, w, e, r, t, y, u, i, o, p, a, s, d, f, g, h, j, k, l, z, x, c, v, b, n, m;

    @FXML
    HBox mysteriousWord;

    @FXML
    ImageView gamePicture;

    @FXML
    public void initialize(){
        loadImageQueue();
        initializeKeyMap();
        loadFile();

        System.out.println(hashMap.size());
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void clickGameKey(){
        boolean letterCorrect = false;
        String result = gameToggleButton.getSelectedToggle().toString();
        char charToggleButton = result.charAt(45);
        gameWindowModel.setFalseValue(charToggleButton);
        System.out.println(charToggleButton);

        if(hashMap.containsKey(charToggleButton)){
            ToggleButton toggleButton = hashMap.get(charToggleButton);
            toggleButton.setVisible(false);
        }

        for (int i = 0; i <word.length ; i++) {
            if (word[i] == charToggleButton){
                Button button = buttons.get(i);
                button.setText(Character.toString(charToggleButton));
                letterCorrect = true;
            }
        }

        if(!letterCorrect){
            gamePicture.setImage(imageQueue.poll());
            gameWindowModel.addQueueIterator();
        }

        if(imageQueue.size()<2){
            System.out.println(prompt);
        }

    }

    private void loadFile(){
        gameWindowModel = fileReader.readGameStatus();
        word = gameWindowModel.getWordName();
        prompt = gameWindowModel.getWordPrompt();
        labelCategory.setText(gameWindowModel.getNameCategory());
        initMapWorld();
        loadAllButtons();
        System.out.println(hashMap);

        for (int i = 0; i <gameWindowModel.getQueueIterator() ; i++) {
            gamePicture.setImage(imageQueue.poll());
        }

    }

    private void loadAllButtons(){
        Map<Character, Boolean> gameKeys = gameWindowModel.getGameKeys();
        for(Map.Entry<Character,Boolean> entry: gameKeys.entrySet()){
            if(!entry.getValue()){
                ToggleButton toggleButton = hashMap.get(entry.getKey());
                toggleButton.setVisible(false);

                for (int i = 0; i <word.length ; i++) {
                    if(entry.getKey() == word[i]){
                        Button button = buttons.get(i);
                        button.setText(Character.toString(entry.getKey()));
                    }
                }
            }
        }
    }

    private void initializeKeyMap(){
        List<ToggleButton> toggleButtons = Arrays.asList(q, w, e, r, t, y, u, i, o,
                p, a, s, d, f, g, h, j, k, l, z, x, c, v, b, n, m);

        for (ToggleButton toggleButtonList: toggleButtons){
            hashMap.put(toggleButtonList.getText().charAt(0),toggleButtonList);
        }
    }


    private void initMapWorld(){
        for (int i = 0; i <word.length ; i++) {
            Button button = new Button();
            button.setDisable(true);
            mysteriousWord.getChildren().add(button);
            buttons.add(button);
        }
    }

    private void loadImageQueue(){
        if (imageList.getLoadPictures()) {
            imageQueue = imageList.getImageQueue();
            gamePicture.setImage(imageQueue.poll());
        }
    }

    @FXML
    private void endGame(){
        //fileWriter.gameStatusWrite(gameWindowModel);
        mainController.loadMenu();
    }
}
