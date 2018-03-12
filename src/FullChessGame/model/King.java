package FullChessGame.model;

import javafx.geometry.Point2D;

public class King extends GenericChessPiece {
    public King(){
        super(ChessPieceType.KING,0,0);
    }
    public King(int x, int y){
        super(ChessPieceType.KING,x,y);
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
