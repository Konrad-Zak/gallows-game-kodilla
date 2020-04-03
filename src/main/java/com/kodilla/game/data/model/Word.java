package com.kodilla.game.data.model;

import java.io.Serializable;

public class Word implements Serializable {
    private static final long serialVersionUID = 3812000077081001111L;

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
