package com.example.musicclub.Models;

public class Language {
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String toString()
    {
        return String.format("%s",language);
    }
}
