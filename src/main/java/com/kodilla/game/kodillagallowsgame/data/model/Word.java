package com.kodilla.game.kodillagallowsgame.data.model;

public class Word {

    private String word;
    private String prompt;

    public Word(String word, String prompt) {
        this.word = word;
        this.prompt = prompt;
    }

    public String getWord() {
        return word;
    }

    public String getPrompt() {
        return prompt;
    }
}
