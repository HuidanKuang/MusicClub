package com.example.musicclub;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class APIUtility {
    /**
     * This method will read the file called "jsonData" and create an ApiResponse object
     */
    public static ApiResponse getMoviesJsonFile()
    {
        //create a GSON object
        Gson gson = new Gson();
        ApiResponse response = null;

        try(
                FileReader fileReader = new FileReader("jsonData");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            response = gson.fromJson(jsonReader, ApiResponse.class);
        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return response;
    }
}