package FullChessGame.model;

import javafx.geometry.Point2D;

public class Bishop extends GenericChessPiece {
    public Bishop(){
        super(ChessPieceType.BISHOP,0,0);
    }
    public Bishop(int x, int y){
        super(ChessPieceType.BISHOP,x,y);
    }
    @Override
    public boolean move(Point2D nextPosition) {
        setCurrentPosition(nextPosition);
        return true;
    }

    @Override
    public void capture() {

    }

    @Override
    public void captured() {

    }
}
