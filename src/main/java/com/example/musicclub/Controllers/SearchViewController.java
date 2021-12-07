package com.example.musicclub.Controllers;

import com.example.musicclub.APIUtility;
import com.example.musicclub.ApiResponse;
import com.example.musicclub.Models.Music;
import com.example.musicclub.SceneChanger;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private Label errMsgLabel;

    @FXML
    private Button getDetailsButton;

    @FXML
    private Label getDetailsLabel;

    @FXML
    private ListView<Music> initialMusicDataListView;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label musicNumLabel;

    @FXML
    private void getSearchResults() throws IOException, InterruptedException {
        initialMusicDataListView.getItems().clear();

        ApiResponse apiResponse = APIUtility.getMusicsFromMusicbrainz(searchTextField.getText());

        if (apiResponse.getCount()!=0)
        {
            initialMusicDataListView.getItems().addAll(apiResponse.getReleases());
            setMusicFound(true,false);
            updateLabel();
        }
        else
        {
            setMusicFound(false,false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setMusicFound(false,false);
        errMsgLabel.setVisible(false);
        initialMusicDataListView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldMusic,musicSelected)->{
                    setMusicFound(true,true);
                }
        );
    }

    /**
     * This method will return visual element to be visible or not visible
     * depending on the state of GUI
     */
    private void setMusicFound(boolean musicFound,boolean musicSelected){
        initialMusicDataListView.setVisible(musicFound);
        musicNumLabel.setVisible(musicFound);
        getDetailsLabel.setVisible(musicFound);
        getDetailsButton.setVisible(musicSelected);
        errMsgLabel.setVisible(!musicFound);
    }

    /**
     * this method will return the number of Musics
     */
    private void updateLabel()
    {
        musicNumLabel.setText("Number of Musics: " + initialMusicDataListView.getItems().size());
    }

    @FXML
    private void getMusicDetails(ActionEvent event) throws IOException, InterruptedException {
        String musicId = initialMusicDataListView.getSelectionModel().getSelectedItem().getId();
        SceneChanger.changeScenes(event,"music-details-view.fxml",musicId);
    }
}
