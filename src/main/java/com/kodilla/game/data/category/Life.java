package com.kodilla.game.data.category;

import com.kodilla.game.data.model.Word;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Life implements Category, Serializable {

    private static final long serialVersionUID = 3812017177085555555L;
    private List<Word> easyLevelWords = new ArrayList<>();
    private List<Word> mediumLevelWords = new ArrayList<>();
    private List<Word> hardLevelWords = new ArrayList<>();
    private Random random = new Random();
    private int number;

    public Life() {
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
        return "Life";
    }

    private void initializeEasyList(){
        easyLevelWords.add(new Word("AUNT","Sister your father"));
        easyLevelWords.add(new Word("FAMILY","Group people love each other and live in the same house"));
        easyLevelWords.add(new Word("CHILD","One children"));
        easyLevelWords.add(new Word("WIFE","Man second part"));
        easyLevelWords.add(new Word("WIDOW","Women after her husband dead"));
        easyLevelWords.add(new Word("NAPPY","Dress in it very little child"));
        easyLevelWords.add(new Word("BRIDAL","Woman in white dress"));
        easyLevelWords.add(new Word("SOUL","Spirit"));
        easyLevelWords.add(new Word("DEAD","Opposite word live"));
        easyLevelWords.add(new Word("LEG","We use it walk"));
    }

    private void initializeMediumList(){
        mediumLevelWords.add(new Word("ACCURATE","Someone who make work very well"));
        mediumLevelWords.add(new Word("TRUTHFUL","Someone who speak truth"));
        mediumLevelWords.add(new Word("EFFUSIVE","Someone who speak a lot"));
        mediumLevelWords.add(new Word("DECEASED","One after dead"));
        mediumLevelWords.add(new Word("FUNERAL","Last way in earth"));
        mediumLevelWords.add(new Word("COLLEGE","Kind of school"));
        mediumLevelWords.add(new Word("GRADUATE","Someone who finish university"));
        mediumLevelWords.add(new Word("TEACHER","Person who conveys knowledge"));
        mediumLevelWords.add(new Word("ACTIVITY","Moving in general"));
        mediumLevelWords.add(new Word("HEALTHY","In good shape"));
    }

    private void initializeHardList(){
        hardLevelWords.add(new Word("REINFORCEMENTS","Meals in general"));
        hardLevelWords.add(new Word("CAPITULATION","Made decision about lose"));
        hardLevelWords.add(new Word("SURROUNDED","Cornered someone"));
        hardLevelWords.add(new Word("ORGANISATION","Group of people in national range"));
        hardLevelWords.add(new Word("INFORMATION","News"));
        hardLevelWords.add(new Word("MEASUREMENT","Give result"));
        hardLevelWords.add(new Word("COMMUNICATION","Just...Talk or chat"));
        hardLevelWords.add(new Word("HOMELESSNESS","Someone who has not house"));
        hardLevelWords.add(new Word("DISSATISFACTION","When we are not agree with something"));
        hardLevelWords.add(new Word("HALLUCINATION","One See something do not exists"));
    }
}
