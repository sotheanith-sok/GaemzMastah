package launcher.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import launcher.model.Program;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class GameListController {
    @FXML private FlowPane gameList;
    MainViewController parentController;


    public void initializeParentController(MainViewController mainViewController){
        parentController=mainViewController;
    }

    public void addAppsToView(ArrayList<Program> appList){
        try{
            System.out.println(appList.size());
            for(int i=0;i<appList.size();i++){
                Program p= appList.get(i);
                Image image=new Image(getClass().getResourceAsStream(p.getIconPath()));
                ImageView imageView= new ImageView(image);
                imageView.setFitHeight(250);
                imageView.setFitWidth(250);
                Button button=new Button(p.getTitle());
                button.setOnAction(event -> p.start());
                button.setGraphic(imageView);
                button.setContentDisplay(ContentDisplay.TOP);
                gameList.getChildren().add(button);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
