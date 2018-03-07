package mancalaGame.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EndgameScreen implements Initializable{
   @FXML
   private MediaView mediaView;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      Stage stage=new Stage();
      stage.show();
   }

}
