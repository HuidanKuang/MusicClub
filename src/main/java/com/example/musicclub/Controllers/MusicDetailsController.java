package com.example.musicclub.Controllers;

import com.example.musicclub.APIUtility;
import com.example.musicclub.InitializeMusic;
import com.example.musicclub.Models.MusicDetails;
import com.example.musicclub.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;


public class MusicDetailsController implements InitializeMusic {

    @FXML
    private Label countryLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label musicTitleLabel;

    @FXML
    private Label qualityLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label languageLabel;


    /**
     * Given the musicID, this method will call the api/json and create a MusicDetails object.
     * This will be used to populate the GUI with the music details
     * @param musicId -- this is musicBrainz release id
     */
    public void loadMusicDetails(String musicId){
        MusicDetails musicDetails = null;
        try {
            musicDetails = APIUtility.getMusicDetails(musicId);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countryLabel.setText(musicDetails.getCountry());
        dateLabel.setText(musicDetails.getDate());
        idLabel.setText(musicDetails.getId());
        musicTitleLabel.setText(musicDetails.getTitle());
        qualityLabel.setText(musicDetails.getQuality());
        statusLabel.setText(musicDetails.getStatus());
        languageLabel.setText(String.valueOf(musicDetails.getLanguage()));

    }

    @FXML
    private void returnToSearch(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"search-view.fxml");
    }

}