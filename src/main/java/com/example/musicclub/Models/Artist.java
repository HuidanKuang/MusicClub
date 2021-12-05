package com.example.musicclub.Models;

public class Artist {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return String.format("%s",name);
    }
}
