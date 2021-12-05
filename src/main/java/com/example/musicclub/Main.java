package com.example.musicclub;

public class Main {
    public static void main(String[] args) {
        ApiResponse result = APIUtility.getMoviesJsonFile();
        System.out.println(result);
    }
}
