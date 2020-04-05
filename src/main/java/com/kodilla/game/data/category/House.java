package com.kodilla.game.data.category;

import com.kodilla.game.data.model.Word;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House implements Category, Serializable {

    private static final long serialVersionUID = 3812017177084444444L;
    private List<Word> easyLevelWords = new ArrayList<>();
    private List<Word> mediumLevelWords = new ArrayList<>();
    private List<Word> hardLevelWords = new ArrayList<>();
    private Random random = new Random();
    private int number;

    public House() {
        initializeEasyList();
        initializeMediumList();
        initializeHardList();
    }

    @Override
    public Word getEasyWord() {
        number = random.nextInt(easyLevelWords.size());
        return easyLevelWords.get(number);
    }

    @Override
    public Word getMediumWord() {
        number = random.nextInt(mediumLevelWords.size());
        return mediumLevelWords.get(number);
    }

    @Override
    public Word getHardWord() {
        number = random.nextInt(hardLevelWords.size());
        return hardLevelWords.get(number);
    }

    @Override
    public String getCategoryName() {
        return "House";
    }

    private void initializeEasyList(){
        easyLevelWords.add(new Word("KNIFE","Use it to cut something"));
        easyLevelWords.add(new Word("FORK","Use it to eat spaghetti"));
        easyLevelWords.add(new Word("FENCE","Railing"));
        easyLevelWords.add(new Word("LADLE","We pour it soup"));
        easyLevelWords.add(new Word("TIN","Coca cola in it"));
        easyLevelWords.add(new Word("BED","Sleep in it"));
        easyLevelWords.add(new Word("DOOR","We close it"));
        easyLevelWords.add(new Word("TEA","We drink it at breakfast"));
        easyLevelWords.add(new Word("CHAIR","Use it to sit"));
        easyLevelWords.add(new Word("IRON","Use it after washing clothes"));
    }

    private void initializeMediumList(){
        mediumLevelWords.add(new Word("FREEZER","Storage of meat several months"));
        mediumLevelWords.add(new Word("BLENDER","Kind of mixer"));
        mediumLevelWords.add(new Word("CLEAVER","Use it to cut meat with bone"));
        mediumLevelWords.add(new Word("SAUCEPAN","Use it to cook soup"));
        mediumLevelWords.add(new Word("KITCHEN","We cook in this place"));
        mediumLevelWords.add(new Word("COLANDER","Help us in cook pasta"));
        mediumLevelWords.add(new Word("SPATULA","Use it when we frying"));
        mediumLevelWords.add(new Word("CUPBOARD","Put there clan cup or plate"));
        mediumLevelWords.add(new Word("BLANKET","Use it when you filling cold"));
        mediumLevelWords.add(new Word("WARDrOBE","We keep in our clothes"));
    }

    private void initializeHardList(){
        hardLevelWords.add(new Word("DESSERTSPOON","Spoon to taste food"));
        hardLevelWords.add(new Word("TUPPERWARE","Keep food in it"));
        hardLevelWords.add(new Word("DISHWASHER","Machine to clean plate, cup..."));
        hardLevelWords.add(new Word("MICROWAVE","Use it to warm food"));
        hardLevelWords.add(new Word("BEDSPREAD","Put in on duvet"));
        hardLevelWords.add(new Word("HAIRDRYER","Hair drying"));
        hardLevelWords.add(new Word("TELEVISION","Watch film on it"));
        hardLevelWords.add(new Word("CURTAINS","Near window"));
        hardLevelWords.add(new Word("SELLOTAPE","Use it to glue two things"));
        hardLevelWords.add(new Word("APARTMENT","Building"));
    }
}
