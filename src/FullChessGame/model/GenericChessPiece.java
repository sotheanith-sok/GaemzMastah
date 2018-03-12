package FullChessGame.model;

import javafx.geometry.Point2D;

public abstract class GenericChessPiece {
    private ChessPieceType type;
    private Point2D currentPosition;
    public GenericChessPiece (){
        type=ChessPieceType.PAWN;
        currentPosition=new Point2D(0,0);
    }
    public GenericChessPiece(ChessPieceType type, int x, int y){
        this.type=type;
        currentPosition=new Point2D(x,y);
    }


    public abstract boolean  move(Point2D nextPosition);
    public abstract void capture();
    public abstract void captured();

    public void setCurrentPosition(Point2D currentPosition) {
        this.currentPosition = currentPosition;
    }
}
