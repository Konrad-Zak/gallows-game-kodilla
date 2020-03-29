package com.kodilla.game.kodillagallowsgame.data;

import java.util.ArrayList;
import java.util.List;

public class Sport {
    public final static String CATEGORY = "Sport";
    private List<Word> easyLevelWords = new ArrayList<>();
    private List<Word> mediumLevelWords = new ArrayList<>();
    private List<Word> hardLevelWords = new ArrayList<>();

    public Sport() {
        easyLevelWords.add(new Word("Smile","newc sos"));
    }
}
