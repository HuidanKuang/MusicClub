package com.example.musicclub.Controllers;

import com.example.musicclub.APIUtility;
import com.example.musicclub.Models.MusicDetails;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MusicDetailsController implements Initializable {


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadMusicDetails("e29a0dee-c141-43b1-b0d8-f0c387c0c642");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Given the musicID, this method will call the api/json and create a MusicDetails object.
     * This will be used to populate the GUI with the music details
     * @param musicId -- this is musicBrainz release id
     */
    public void loadMusicDetails(String musicId) throws IOException, InterruptedException {
        MusicDetails musicDetails = APIUtility.getMusicDetails(musicId);
        countryLabel.setText(musicDetails.getCountry());
        dateLabel.setText(musicDetails.getDate());
        idLabel.setText(musicDetails.getId());
        musicTitleLabel.setText(musicDetails.getTitle());
        qualityLabel.setText(musicDetails.getQuality());
        statusLabel.setText(musicDetails.getStatus());
        languageLabel.setText(String.valueOf(musicDetails.getLanguage()));

    }

}