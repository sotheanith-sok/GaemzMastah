package FullChessGame.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
   @FXML GameViewController gameViewController;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      gameViewController.setMainViewController(this);
   }
   public  void start(){
      gameViewController.start();
   }
}
