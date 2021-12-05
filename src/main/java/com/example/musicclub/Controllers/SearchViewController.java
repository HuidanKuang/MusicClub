package com.example.musicclub.Controllers;

import com.example.musicclub.APIUtility;
import com.example.musicclub.ApiResponse;
import com.example.musicclub.Models.Music;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SearchViewController {

    @FXML
    private Label errMsgLabel;

    @FXML
    private VBox getDetailsButton;

    @FXML
    private ListView<Music> initialMusicDataListView;

    @FXML
    private TextField searchTextField;

    @FXML
    private void getSearchResults() throws IOException, InterruptedException {
        ApiResponse apiResponse = APIUtility.getMusicsFromMusicbrainz(searchTextField.getText());

        if (apiResponse != null)
        {
            initialMusicDataListView.getItems().addAll(apiResponse.getReleases());
        }
    }
}
