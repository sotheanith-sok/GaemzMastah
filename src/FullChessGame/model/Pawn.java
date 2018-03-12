package FullChessGame.model;

import javafx.geometry.Point2D;

public class Pawn extends GenericChessPiece {

    public Pawn(){
        super(ChessPieceType.PAWN,0,0);
    }
    public Pawn(int x, int y){
        super(ChessPieceType.PAWN,x,y);
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
