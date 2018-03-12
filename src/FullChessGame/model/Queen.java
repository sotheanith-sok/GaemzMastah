package FullChessGame.model;

import javafx.geometry.Point2D;

public class Queen extends GenericChessPiece{
    public Queen(){
        super(ChessPieceType.QUEEN,0,0);
    }
    public Queen(int x, int y){
        super(ChessPieceType.QUEEN,x,y);
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
