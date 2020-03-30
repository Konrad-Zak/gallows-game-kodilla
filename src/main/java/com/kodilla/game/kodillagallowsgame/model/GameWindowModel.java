package com.kodilla.game.kodillagallowsgame.model;

import com.kodilla.game.kodillagallowsgame.data.CategoryList;
import com.kodilla.game.kodillagallowsgame.data.category.Category;
import com.kodilla.game.kodillagallowsgame.data.model.Word;

import java.io.Serializable;
import java.util.*;

public class GameWindowModel implements Serializable {
    private static final long serialVersionUID = 3812017177088221111L;

    private Map<Character,Boolean> gameKeys;
    private Category category;
    private Word word;


    public GameWindowModel() {
        initializeMaps();
        CategoryList categoryList = new CategoryList();
        category = categoryList.getName();
        word = category.getEasyWord();
    }

    public void setFalseValue(Character character){
        gameKeys.replace(character,false);
        System.out.println(gameKeys);
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

    public void setGameKeys(Map<Character, Boolean> gameKeys) {
        this.gameKeys = gameKeys;
    }

    private void initializeMaps(){
        List<Character> keys = Arrays.asList('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
                'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M');
        gameKeys = new HashMap<>();
        for (Character key: keys){
            gameKeys.put(key,true);
        }
    }
}
