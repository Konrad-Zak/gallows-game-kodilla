package com.kodilla.game.data.category;

import com.kodilla.game.data.model.Word;

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
        return "Sport";
    }

    private void initializeEasyList(){
        easyLevelWords.add(new Word("ARENA","Battleground"));
        easyLevelWords.add(new Word("BOXING","Type fight competition"));
        easyLevelWords.add(new Word("CUE","Billiard tool"));
        easyLevelWords.add(new Word("MEDAL","Kind of trophy"));
        easyLevelWords.add(new Word("TEAM","Group of players"));
        easyLevelWords.add(new Word("BALL","We use it to play soccer"));
        easyLevelWords.add(new Word("CLUB", "Association of players"));
        easyLevelWords.add(new Word("MVP", "Best player in game"));
        easyLevelWords.add(new Word("COACH","Player trainer"));
        easyLevelWords.add(new Word("BOWLER","Serving player"));
    }

    private void initializeMediumList(){
        mediumLevelWords.add(new Word("ATHLETE","SportsMan"));
        mediumLevelWords.add(new Word("CHAMPION", "Master"));
        mediumLevelWords.add(new Word("Bowling", "Game in bowls"));
        mediumLevelWords.add(new Word("DEFENSE","Guard"));
        mediumLevelWords.add(new Word("EXERCISE","Training"));
        mediumLevelWords.add(new Word("JAVELIN", "Spear"));
        mediumLevelWords.add(new Word("MOVEMENT", "Motion"));
        mediumLevelWords.add(new Word("PAINTBALL", "Paint gun"));
        mediumLevelWords.add(new Word("PARKOUR", "Free run"));
        mediumLevelWords.add(new Word("TEAMMATE", "Sport partner"));
    }

    private void initializeHardList(){
        hardLevelWords.add(new Word("BADMINTON", "Game with rocket"));
        hardLevelWords.add(new Word("CHAMPIONSHIP", "Mastery"));
        hardLevelWords.add(new Word("COMPETITOR", "Rival"));
        hardLevelWords.add(new Word("DEADLIFTING","Exercise in weight competition"));
        hardLevelWords.add(new Word("GEOCACHING", "Searching for items in the field"));
        hardLevelWords.add(new Word("SCOREBOARD","Table with score"));
        hardLevelWords.add(new Word("SNOWBOARDING","Type of winter sport"));
        hardLevelWords.add(new Word("MOUTHGUARD","Mouth protector"));
        hardLevelWords.add(new Word("QUARTERBACK","Main player in team"));
        hardLevelWords.add(new Word("ULTRAMARATHON","Type of marathon"));
    }
}
