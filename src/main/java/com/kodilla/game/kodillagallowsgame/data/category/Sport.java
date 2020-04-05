package com.kodilla.game.kodillagallowsgame.data.category;

import com.kodilla.game.kodillagallowsgame.data.model.Word;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sport  implements Category,Serializable {
    private static final long serialVersionUID = 3812017177081111111L;
    private List<Word> easyLevelWords = new ArrayList<>();
    private List<Word> mediumLevelWords = new ArrayList<>();
    private List<Word> hardLevelWords = new ArrayList<>();
    private Random random = new Random();
    private int number;

    public Sport() {
        initializeEasyList();
    }



    @Override
    public Word getEasyWord() {
        number = random.nextInt(easyLevelWords.size());
         return easyLevelWords.get(number);
    }

    @Override
    public Word getMediumWord() {
        return easyLevelWords.get(0);
    }

    @Override
    public Word getHardWord() {
        return easyLevelWords.get(0);
    }

    @Override
    public String getCategoryName() {
        return "Sport";
    }

    private void initializeEasyList(){
        easyLevelWords.add(new Word("ARENA","Battleground"));
        easyLevelWords.add(new Word("BOXING","Type fight competition"));
        easyLevelWords.add(new Word("CUE","Billiard tool"));
        easyLevelWords.add(new Word("MEDAL","Kind of trophy"));
        easyLevelWords.add(new Word("TEAM","Group of players"));
    }
}
