package com.example.musicclub;

import com.example.musicclub.Models.Music;

public class ApiResponse {
    private String created;
    private int count, offset;
    private Music[] releases;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Music[] getReleases() {
        return releases;
    }

    public void setReleases(Music[] releases) {
        this.releases = releases;
    }
}
