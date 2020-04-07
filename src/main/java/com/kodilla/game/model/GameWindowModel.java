package com.kodilla.game.model;

import com.kodilla.game.data.CategoryList;
import com.kodilla.game.data.category.Category;
import com.kodilla.game.data.model.Word;
import com.kodilla.game.io.FileReader;
import com.kodilla.game.io.FileWriter;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class GameWindowModel implements Serializable {
    private static final long serialVersionUID = 3812017177088221111L;

    private Map<Character,Boolean> gameKeys;
    private Category category;
    private Word word;
    private SettingsMenuModel settingsMenuModel;
    private int queueIterator;

    public GameWindowModel() {
        initializeMaps();
        loadSettingsMenu();
        initializeWord();
        queueIterator = 0;
    }

    public void setFalseValue(Character character){
        gameKeys.replace(character,false);
    }

    public Map<Character, Boolean> getGameKeys() {
        return gameKeys;
    }

    public String getNameCategory() {
        return category.getCategoryName();
    }

    public char[] getWordName(){
        return word.getWord().toCharArray();
    }

    public String getWordPrompt(){
        return word.getPrompt();
    }

    public int getQueueIterator() {
        return queueIterator;
    }

    public void addQueueIterator(){
        queueIterator++;
    }

    private void initializeMaps(){
        List<Character> keys = Arrays.asList('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
                'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M');

        gameKeys = keys.stream()
                .collect(Collectors.toMap(k -> k, k -> true));
    }

    private void loadSettingsMenu(){
        FileReader fileReader = new FileReader();

        if(Files.exists(Paths.get(FileWriter.SETTINGS_FILE_NAME))){
            settingsMenuModel = fileReader.readSettingsModel();
        } else {
            settingsMenuModel = new SettingsMenuModel();
        }
    }

    private void initializeWord(){
        getCategoryGame();
        getLevelWord();
    }

    private void getCategoryGame(){
        List<String> categoryList;
        CategoryList list = new CategoryList();
        Random random = new Random();
        Map<String, Category> categories = list.getCategoryWord();
        Map<String, Boolean> checkBoxMap = settingsMenuModel.getCheckBoxMap();

        categoryList = checkBoxMap.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int number = random.nextInt(categoryList.size());
        category = categories.get(categoryList.get(number));
    }

    private void getLevelWord(){
        if(settingsMenuModel.getRadioButtonEasy()){
            word = category.getEasyWord();
        } else if(settingsMenuModel.getRadioButtonMedium()){
            word = category.getMediumWord();
        } else {
            word = category.getHardWord();
        }
    }

}
