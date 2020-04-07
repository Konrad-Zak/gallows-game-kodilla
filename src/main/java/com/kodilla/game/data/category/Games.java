package com.kodilla.game.data.category;

import com.kodilla.game.data.model.Word;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Games implements Category, Serializable {

    private static final long serialVersionUID = 3812017177083333333L;
    private List<Word> easyLevelWords = new ArrayList<>();
    private List<Word> mediumLevelWords = new ArrayList<>();
    private List<Word> hardLevelWords = new ArrayList<>();
    private Random random = new Random();
    private int number;

    public Games() {
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
        return "Games";
    }

    private void initializeEasyList(){
        easyLevelWords.add(new Word("BOT","Program automated character"));
        easyLevelWords.add(new Word("BOSS","Hard enemy"));
        easyLevelWords.add(new Word("CHEAT","Code that uses bugs in the game"));
        easyLevelWords.add(new Word("EVENT", "Happening"));
        easyLevelWords.add(new Word("FPS", "First person shooter"));
        easyLevelWords.add(new Word("FRAG","Defeating an opponent from the opposing team"));
        easyLevelWords.add(new Word("ITEM","Object"));
        easyLevelWords.add(new Word("NOOB", "Person representing low skills in the game"));
        easyLevelWords.add(new Word("QUEST","Game world"));
        easyLevelWords.add(new Word("SKILL","Ability"));
    }

    private void initializeMediumList(){
        mediumLevelWords.add(new Word("CHEATER","Person who uses mistakes in the game"));
        mediumLevelWords.add(new Word("CRITICAL","Critical blow"));
        mediumLevelWords.add(new Word("RESPAWN","Place where players come back to life"));
        mediumLevelWords.add(new Word("STREAMER","Player broadcasting how he plays"));
        mediumLevelWords.add(new Word("SUPPORT","Help other player"));
        mediumLevelWords.add(new Word("SANDBOX","Computer games design type"));
        mediumLevelWords.add(new Word("TUTORIAL","Learning game rule"));
        mediumLevelWords.add(new Word("CARAVAN","Easy loot"));
        mediumLevelWords.add(new Word("CASHBACK","Money return"));
        mediumLevelWords.add(new Word("CRAFTING","Character skills and traits"));
    }

    private void initializeHardList(){
        hardLevelWords.add(new Word("MULTIPLAYER","Game with other player"));
        hardLevelWords.add(new Word("ASSASSINATE","Kill in order"));
        hardLevelWords.add(new Word("PANZERFAUST","Weapon"));
        hardLevelWords.add(new Word("SCALABILITY","Can calibrate"));
        hardLevelWords.add(new Word("ACHIEVEMENT","Attainment"));
        hardLevelWords.add(new Word("RECONNAISSANCE","Diagnosis"));
        hardLevelWords.add(new Word("INTERNATIONAL","Rank tournament"));
        hardLevelWords.add(new Word("COMPETITION","Tournament"));
        hardLevelWords.add(new Word("UNSCRAMBLE","Break code"));
        hardLevelWords.add(new Word("BATTLEGROUNDS", "Battle place"));
    }
}
