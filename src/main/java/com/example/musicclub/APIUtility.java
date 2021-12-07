package com.example.musicclub;

import com.example.musicclub.Models.Music;
import com.example.musicclub.Models.MusicDetails;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    /**
     * This method will read the file called "jsonData" and create an ApiResponse object
     * This is to ensure the API response is working
     */
    public static ApiResponse getMusicsJsonFile()
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

    /**
     * This will call the musicbrainz API with the specific search term
     */
    public static ApiResponse getMusicsFromMusicbrainz(String searchTerm) throws IOException, InterruptedException {
        searchTerm = searchTerm.trim().replace(" ","%20");

        String uri = "https://musicbrainz.org/ws/2/release/?query=" + searchTerm + "&fmt=json";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this approach stores the API response to a String
        HttpResponse<String> response = client.send(httpRequest,HttpResponse.BodyHandlers.ofString());

        String jsonString = response.body();

        Gson gson = new Gson();
        ApiResponse apiResponse = null;

        try{
            apiResponse = gson.fromJson(jsonString,ApiResponse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  apiResponse;
    }

    /**
     * This will call the musicBrainz API with music ID
     * @param musicId
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static MusicDetails getMusicDetails(String musicId) throws IOException, InterruptedException {
        musicId = musicId.trim().replace(" ","%20");

        String uri = "https://musicbrainz.org/ws/2/release/" + musicId + "?fmt=json";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this approach stores the API response to a String
        HttpResponse<String> response = client.send(httpRequest,HttpResponse.BodyHandlers.ofString());

        String jsonString = response.body();
        Gson gson = new Gson();

        return gson.fromJson(response.body(),MusicDetails.class);
    }
}
