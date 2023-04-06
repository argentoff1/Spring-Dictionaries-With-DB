package com.mmtr.dictionariesspringboot.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Dictionary {
    private int id;

    @NotEmpty(message = "Word should not be empty")
    @Size(min = 4, max = 5, message = "Word should be 4 characters")
    private String word;

    @NotEmpty(message = "А translation of а word should not be empty")
    @Size(min = 5, max = 5, message = "А translation of а word should be 5 characters")
    private String translatedWord;

    public Dictionary(int id, String word, String translatedWord) {
        this.id = id;
        this.word = word;
        this.translatedWord = translatedWord;
    }

    public Dictionary() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setTranslatedWord(String translatedWord) {
        this.translatedWord = translatedWord;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }
}
