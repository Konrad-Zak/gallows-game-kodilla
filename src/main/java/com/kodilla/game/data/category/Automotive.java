package com.kodilla.game.data.category;

import com.kodilla.game.data.model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Automotive implements Category{

    private List<Word> easyLevelWords = new ArrayList<>();
    private List<Word> mediumLevelWords = new ArrayList<>();
    private List<Word> hardLevelWords = new ArrayList<>();
    private Random random = new Random();
    private int number;

    public Automotive() {
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
        return "Automotive";
    }

    private void initializeEasyList(){
        easyLevelWords.add(new Word("TIRE","Part of wheel"));
        easyLevelWords.add(new Word("CAR","Vehicle"));
        easyLevelWords.add(new Word("ABS","Automatic break system"));
        easyLevelWords.add(new Word("PETROL","Car need to work"));
        easyLevelWords.add(new Word("BREAK","You use it in dangerous situation"));
        easyLevelWords.add(new Word("ENGINE","Car heart"));
        easyLevelWords.add(new Word("SENSOR","Use it to make control different system in car"));
        easyLevelWords.add(new Word("RIM","We put a tire on it"));
        easyLevelWords.add(new Word("FILTER", "Cleans the air"));
        easyLevelWords.add(new Word("COOLER", "Part of the cooling system"));
    }

    private void initializeMediumList(){
        mediumLevelWords.add(new Word("SUSPENSION","Connects wheels and chassis"));
        mediumLevelWords.add(new Word("BATTERY","In electrical car"));
        mediumLevelWords.add(new Word("CYLINDER", "Part in engine"));
        mediumLevelWords.add(new Word("COMPRESSOR","Raises pressure"));
        mediumLevelWords.add(new Word("TIGHTENER","Maintaining proper timing belt tension"));
        mediumLevelWords.add(new Word("REFLECTOR","Car lights"));
        mediumLevelWords.add(new Word("CABRIOLET", "Type of car"));
        mediumLevelWords.add(new Word("Thermostat","Temperature sensor"));
        mediumLevelWords.add(new Word("DRIFTING","Style drive car"));
        mediumLevelWords.add(new Word("LIMOUSINE","Type of car"));
    }

    private void initializeHardList(){
        hardLevelWords.add(new Word("CONDITIONNING","A/C"));
        hardLevelWords.add(new Word("DECELERATION","Decrease speed"));
        hardLevelWords.add(new Word("IMMOBILIZER","Car security system"));
        hardLevelWords.add(new Word("ACCELERATION","Speeding"));
        hardLevelWords.add(new Word("CARBURRETTOR","CARB"));
        hardLevelWords.add(new Word("TURBOCHARGER","use it to more power in car"));
        hardLevelWords.add(new Word("DIFFERENTIAL","gear mechanical transmission"));
        hardLevelWords.add(new Word("TRANSMISSION", "In automatic gearbox"));
        hardLevelWords.add(new Word("ELECTROMECHANICAL","EMB system"));
        hardLevelWords.add(new Word("POSITIONING","GPS system"));
    }
}
