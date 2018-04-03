package launcher.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Font;
import launcher.model.Program;
import launcher.model.ProgramManager;

import java.util.ArrayList;

public class MainViewController {
   @FXML
   TopLogoController topLogoController;
   @FXML
   BottomLogoController bottomLogoController;
   @FXML
   GameListController gameListController;
   ProgramManager programManager;

   public MainViewController() {

      try{
         ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
         programManager = new ProgramManager("launcher/resources/Database.xml");
         Font.loadFont(classLoader.getResource("launcher/resources/Sabo-Regular.otf").toExternalForm(),10);
      }catch (Exception e){
         e.printStackTrace();
      }


   }

   @FXML
   public void initialize() {
      gameListController.setMainViewController(this);
      gameListController.addAppsToView(new ArrayList<Program>(programManager.getAppList()));
   }
}
