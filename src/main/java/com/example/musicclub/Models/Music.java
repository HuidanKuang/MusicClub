package com.example.musicclub.Models;

import com.google.gson.annotations.SerializedName;

public class Music {
    private String title;
    private String id;
    private int score;
    private String date;
    private String country;

    @SerializedName("artist-credit")
    private Artist[] artist;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Artist[] getArtist() {
        return artist;
    }

    public String getArtists(){
        String artists = "";

        for (int i=0;i<artist.length;i++)
        {
            artists = artists + artist[i] + ", ";
        }

        return artists.substring(0,artists.length()-2);
    }

    public void setArtist(Artist[] artist) {
        this.artist = artist;
    }

    public String toString()
    {
        return String.format("%s - %s",title,getArtists());
    }
}
