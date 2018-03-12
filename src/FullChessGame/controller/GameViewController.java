package FullChessGame.controller;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class GameViewController implements Initializable{
    final int size=8;
    private ImageView[][] pieces=new ImageView[100][100];
    private Rectangle[][] board=new Rectangle[8][8];

    @FXML
    private GridPane gridPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createBoard();
        createPiece();


    }
    public void createBoard(){
        for(int i=0;i<size;i++){
            for (int j =0; j<size;j++){
                Rectangle rectangle=new Rectangle();
                if((i+j)%2==0){
                    rectangle.setFill(Color.web("#ffffff"));
                }else {
                    rectangle.setFill(Color.web("#000000"));
                }
                rectangle.heightProperty().bind(((StackPane)gridPane.getParent()).heightProperty().divide(size));
                rectangle.widthProperty().bind(((StackPane)gridPane.getParent()).heightProperty().divide(size));
                gridPane.add(rectangle,i,j);
                board[j][i]=rectangle;
                rectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    printClickedGrid(event);

                });
            }
        }
    }

    public void printClickedGrid(MouseEvent e){
        Node node=(Node)e.getSource();
        Bounds bounds=gridPane.getBoundsInLocal();
        double x=GridPane.getColumnIndex(node);
        double y=GridPane.getRowIndex(node);

        move(1,0, (int) ((bounds.getWidth()*(x/8))), (int) (bounds.getHeight()*(y/8)));
    }
    public void createPiece(){
        Rectangle a=(Rectangle)getNodeByRowColumnIndex(0,0);
        //White
        ImageView imageView;
        for (int i=0;i<8;i++){
            imageView = new ImageView(new Image("FullChessGame/resources/chessPieces/B_Pawn.png"));
            imageView.fitHeightProperty().bind(a.heightProperty());
            imageView.fitWidthProperty().bind(a.widthProperty());
            pieces[1][i]=imageView;
            gridPane.getChildren().add(imageView);

        }

    }

    public Node getNodeByRowColumnIndex (final int row, final int column) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for (Node node : childrens) {
            if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                System.out.println(gridPane.getBoundsInParent());
                break;
            }
        }

        return result;
    }
    public void move(int x1, int y1, double x2, double y2){
        System.out.println(x2+" "+y2);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.1));
        translateTransition.setNode(pieces[x1][y1]);
        translateTransition.setToX(x2);
        translateTransition.setToY(y2);

        translateTransition.play();
    }
}

