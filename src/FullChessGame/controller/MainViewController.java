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
        selected=null;
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

        int result=chessManager.move((int)selected.getX(),(int)selected.getY(),x,y);
        if(result==1){
            gameViewController.move((int)selected.getX(),(int)selected.getY(),x,y);
        }
        if(result==2){
           gameViewController.capture((int)selected.getX(),(int)selected.getY(),x,y);
        }
        selected=null;



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
   public Point2D getSelected(){
       return selected;
   }
}
