package com.kodilla.game.controller;

import com.kodilla.game.data.ImageList;
import com.kodilla.game.dialog.DialogUtils;
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
    private int correctLetterInWord = 0;

    private DialogUtils dialogUtils = new DialogUtils();
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
                correctLetterInWord++;
            }
        }

        if(!letterCorrect){
            gamePicture.setImage(imageQueue.poll());
            gameWindowModel.addQueueIterator();
            checkGameStatus();
        }

        if(correctLetterInWord == word.length){
            setEndGameResult("You Win... Click ok to return Menu");
            mainController.loadMenu();
        }

    }

    private void checkGameStatus(){
        if(imageQueue.size() == 1){
            dialogUtils.informationDialog("Prompt", prompt);
        } else if (imageQueue.size()<1){
            setEndGameResult("You Lose...Click ok to return Menu");
        }
    }

    private void setEndGameResult(String header){
        dialogUtils.informationDialog("End Game",header);
        mainController.loadMenu();
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
        System.out.println("nowy " + gameKeys);
        for(Map.Entry<Character,Boolean> entry: gameKeys.entrySet()){
            if (!entry.getValue()){
                changeButtons(entry.getKey());
            }
        }
    }

    private void changeButtons( Character character){
        deactivateToggleButton(character);
        makeUpLetter(character);
    }

    private void deactivateToggleButton(Character character){
        ToggleButton toggleButton = hashMap.get(character);
        toggleButton.setVisible(false);
    }

    private void makeUpLetter(Character character){
        for (int i = 0; i <word.length ; i++) {
            if(character == word[i]){
                Button button = buttons.get(i);
                button.setText(Character.toString(character));
                correctLetterInWord++;
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
        Optional<ButtonType> endConfirmButton = dialogUtils.confirmDialog("Save Game",
                "Would You like to save this game ?");
        if(imageQueue.size()>1 && endConfirmButton.isPresent() && endConfirmButton.get() == ButtonType.OK){
            fileWriter.gameStatusWrite(gameWindowModel);
        }
        mainController.loadMenu();
    }
}
