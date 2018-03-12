package FullChessGame.controller;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;

public class GameViewController{
    final int size=15;
    private ImageView[][] pieces=new ImageView[size][size];
    private Rectangle[][] board=new Rectangle[size][size];
    @FXML
    private GridPane gridPane;
    private MainViewController mainViewController;
    public void createBoard(){
        for(int i=0;i<size;i++){
            for (int j =0; j<size;j++){
                Rectangle rectangle=new Rectangle();
                if((i+j)%2==0){
                    rectangle.setFill(Color.web("#ffffff"));
                }else {
                    rectangle.setFill(Color.web("#333333"));
                }
                rectangle.heightProperty().bind(((StackPane)gridPane.getParent()).heightProperty().divide(size));
                rectangle.widthProperty().bind(((StackPane)gridPane.getParent()).heightProperty().divide(size));
                board[i][j]=rectangle;
                gridPane.add(rectangle,i,j);

                rectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    printClickedGrid(event);
                    clearEffect();
                });
            }
        }
    }
    public void start(){
        gridPane.getChildren().removeAll();
        createBoard();
        createPiece();
    }

    public void printClickedGrid(MouseEvent e){
        Node node=(Node)e.getSource();
        Bounds bounds=gridPane.getBoundsInLocal();
        int x=GridPane.getColumnIndex(node);
        int y=GridPane.getRowIndex(node);

        move((int)(size/2),(int)(size/2),x,y);


    }
    public void createPiece(){
        Rectangle a=board[0][0];
        //Black piece
        //Pawn
        ImageView imageView;
        for (int i=0;i<board[0].length;i++){
            imageView = new ImageView(new Image("FullChessGame/resources/chessPieces/B_Pawn.png"));
            imageView.fitHeightProperty().bind(a.heightProperty());
            imageView.fitWidthProperty().bind(a.widthProperty());
            gridPane.getChildren().add(imageView);
            pieces[size/2][size/2]=imageView;
            move((int)(size/2),(int)(size/2),i,1);
        }

        //White Piece
        //Pawn
        for (int i=0;i<board[0].length;i++){
            imageView = new ImageView(new Image("FullChessGame/resources/chessPieces/W_Pawn.png"));
            imageView.fitHeightProperty().bind(a.heightProperty());
            imageView.fitWidthProperty().bind(a.widthProperty());
            gridPane.getChildren().add(imageView);
            pieces[size/2][size/2]=imageView;
            move((int)(size/2),(int)(size/2),i,size-2);
        }








    }
    public Node getNodeByRowColumnIndex (final int column, final int row) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }

    public void move(int x1, int y1, int x2, int y2){
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.1));
        translateTransition.setNode(pieces[y1][x1]);
        Bounds bounds=board[x2][y2].getBoundsInParent();
        System.out.println(board[x2][y2]);
        System.out.println(board[x2][y2].getBoundsInParent());
        translateTransition.setToX(bounds.getMinX());
        translateTransition.setToY(bounds.getMinY());
        translateTransition.play();
        /*pieces[x2][y2]=pieces[x1][y1];
        pieces[x1][y1]=null;*/


    }
    public void displayAvaialableMove(List<Point2D> list){
        for(Point2D point2D:list){
            board[(int) point2D.getX()][(int) point2D.getY()].getStyleClass().add("blueFate");
        }
    }
    public void displayAvailableCapture(List<Point2D> list){
        for(Point2D point2D:list){
            board[(int) point2D.getX()][(int) point2D.getY()].getStyleClass().add("redFate");
        }
    }
    public void displaySelectedPiece(Point2D point2D){
        board[(int) point2D.getX()][(int) point2D.getY()].getStyleClass().add("yellowFate");
    }

    public  void clearEffect(){
        for(int i=0; i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j].getStyleClass().clear();
            }
        }
    }

    public void setMainViewController(MainViewController mainViewController){
        this.mainViewController=mainViewController;
    }
}

