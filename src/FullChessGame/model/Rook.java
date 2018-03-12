package FullChessGame.model;

import javafx.geometry.Point2D;

public class Rook extends GenericChessPiece {

    public Rook(){
        super(ChessPieceType.ROOK,0,0);
    }
    public Rook(int x, int y){
        super(ChessPieceType.ROOK,x,y);
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
