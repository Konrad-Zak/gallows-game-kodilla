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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GameWindowController {

    private MainController mainController;
    private GameWindowModel gameWindowModel;
    private Queue<Image> imageQueue;
    private char[] word;
    private String prompt;
    private int correctLetterInWord = 0;
    private boolean letterCorrect;

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
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void clickGameKey(){
        letterCorrect = false;
        String result = gameToggleButton.getSelectedToggle().toString();
        char charToggleButton = result.charAt(45);

        gameWindowModel.setFalseValue(charToggleButton);

        disabledToggleButton(charToggleButton);

        findLetterInWord(charToggleButton);

        clickIncorrectToggleButton();

        checkIfWinGame();

    }

    private void disabledToggleButton(char charToggleButton){
        if(hashMap.containsKey(charToggleButton)){
            ToggleButton toggleButton = hashMap.get(charToggleButton);
            toggleButton.setVisible(false);
        }
    }

    private void findLetterInWord(char charToggleButton){
        for (int i = 0; i <word.length ; i++) {
            if (word[i] == charToggleButton){
                Button button = buttons.get(i);
                button.setText(Character.toString(charToggleButton));
                letterCorrect = true;
                correctLetterInWord++;
            }
        }
    }

    private void clickIncorrectToggleButton(){
        if(!letterCorrect){
            gamePicture.setImage(imageQueue.poll());
            gameWindowModel.addQueueIterator();
            if (imageQueue.size()<2){
                checkGameStatus();
            }
        }
    }


    private void checkGameStatus(){
        if(imageQueue.size() == 1){
            dialogUtils.informationDialog("Prompt", prompt);
        } else {
            setEndGameResult("You Lose \n Would You like to play again");
        }
    }

    private void setEndGameResult(String header){
        Optional<ButtonType> confirmButton = dialogUtils.confirmDialog("End Game",header);

        if (confirmButton.isPresent() && confirmButton.get() == ButtonType.OK){
            MainMenuController mainMenuController = new MainMenuController();
            mainMenuController.setMainController(mainController);
            mainMenuController.startGame();
        } else {
            mainController.loadMenu();
        }
    }

    private void checkIfWinGame(){
        if(correctLetterInWord == word.length){
            setEndGameResult("You Win... Would You like to play again");
        }
    }

    private void prepareStartGame(){
        gameWindowModel = new GameWindowModel();

        if(Files.exists(Paths.get(FileWriter.GAME_STATUS))) {
            loadSaveGame();
        }
    }

    private void loadSaveGame(){
        Optional<ButtonType> optionalButtonType = dialogUtils.confirmDialog("Prepare game",
                "Would like to finish last save game? If not game status will be delete");

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.OK) {
            gameWindowModel = fileReader.readGameStatus();
        } else {
            dialogUtils.informationDialog("Delete save game file","File delete");
            deleteFile();
        }
    }

    private void deleteFile(){
        try {
             Files.delete(Paths.get(FileWriter.GAME_STATUS));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadFile(){
        prepareStartGame();
        loadTextDate();
        initMapWorld();
        loadAllButtons();
        setCurrentImage();
    }

    private void loadTextDate(){
        word = gameWindowModel.getWordName();
        prompt = gameWindowModel.getWordPrompt();
        labelCategory.setText(gameWindowModel.getNameCategory());
    }

    private void loadAllButtons(){
        Map<Character, Boolean> gameKeys = gameWindowModel.getGameKeys();

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

    private void setCurrentImage(){
        for (int i = 0; i <gameWindowModel.getQueueIterator() ; i++) {
            gamePicture.setImage(imageQueue.poll());
        }
    }

    private void initializeKeyMap(){
        List<ToggleButton> toggleButtons = Arrays.asList(q, w, e, r, t, y, u, i, o,
                p, a, s, d, f, g, h, j, k, l, z, x, c, v, b, n, m);

        toggleButtons.forEach(k-> hashMap.put(k.getText().charAt(0),k));
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
        Optional<ButtonType> confirmButton= dialogUtils.confirmDialog("Save Game",
                "Would You like to save this game ?");

        if(imageQueue.size()>1 && confirmButton.isPresent() && confirmButton.get() == ButtonType.OK){
            fileWriter.gameStatusWrite(gameWindowModel);
        }
        mainController.loadMenu();
    }
}
