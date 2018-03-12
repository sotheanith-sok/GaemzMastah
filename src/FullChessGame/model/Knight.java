package FullChessGame.model;

import javafx.geometry.Point2D;

public class Knight extends GenericChessPiece {

    public Knight(){
        super(ChessPieceType.KNIGHT,0,0);
    }
    public Knight(int x, int y){
        super(ChessPieceType.KNIGHT,x,y);
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
