package FullChessGame.model;

import javafx.geometry.Point2D;

import java.util.List;

public class Bishop extends GenericChessPiece {
    public Bishop(){
        super(ChessPieceType.BISHOP,0,0,0);
    }
    public Bishop(int x, int y, int owner){
        super(ChessPieceType.BISHOP,x,y, owner);
    }


    @Override
    public void capture() {

    }

    @Override
    public void captured() {

    }

    @Override
    public List<Point2D> availableMove(int size) {
        return null;
    }

    @Override
    public List<Point2D> availableCapture(int size) {
        return null;
    }
}
