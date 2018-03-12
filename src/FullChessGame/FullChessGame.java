package FullChessGame;

import FullChessGame.controller.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class FullChessGame extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FullChessGame/view/MainView.fxml"));
            Parent root = fxmlLoader.load();
            MainViewController controller=fxmlLoader.getController();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Chess");
            primaryStage.setMaximized(true);
            primaryStage.show();
            controller.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
