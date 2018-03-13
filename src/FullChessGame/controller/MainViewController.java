package FullChessGame.controller;

import FullChessGame.model.ChessManager;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
   @FXML GameViewController gameViewController;
   private ChessManager chessManager;
   private Point2D selected;
    public MainViewController(){
        chessManager=new ChessManager();
        selected=new Point2D(-1,-1);
    }
   @Override
   public void initialize(URL location, ResourceBundle resources) {
      gameViewController.setMainViewController(this);
   }
   public  void start(){
      gameViewController.start();
   }

   public void rePositionAllPieces(Stage stage){
       PauseTransition pause = new PauseTransition(Duration.seconds(0.01));
       stage.xProperty().addListener((obs, oldVal, newVal) ->{
           pause.setOnFinished(event -> gameViewController.rePositionAllPieces());
           pause.playFromStart();
       });
       stage.yProperty().addListener((obs, oldVal, newVal) ->{
           pause.setOnFinished(event -> gameViewController.rePositionAllPieces());
           pause.playFromStart();
       });

   }
   public void play(int x,int y){
        System.out.println("Attempt to move:("+selected.getX()+","+selected.getY()+") to ("+x+", "+y+")");
        boolean didMove=chessManager.move((int)selected.getX(),(int)selected.getY(),x,y);
        if(didMove){
            gameViewController.move((int)selected.getX(),(int)selected.getY(),x,y);
        }




   }
   public void displayMove(int x,int y){
       if(chessManager.getAvailableMove(x,y).size()>0){
           gameViewController.displayAvailableMove(chessManager.getAvailableMove(x,y));
       }
       if(chessManager.getAvailableCapture(x,y).size()>0){
           gameViewController.displayAvailableCapture(chessManager.getAvailableCapture(x,y));
       }
   }
   public void setSelected(Point2D point2D){
        this.selected=point2D;
   }
}
