package FullChessGame.model;

import javafx.geometry.Point2D;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ChessManager {
    final int size=6;
    private GenericChessPiece[][] board ;

    public ChessManager(){
        board=new GenericChessPiece[size][size];
        start();
    }
    public void start(){
        clearBoard();
        initializeBoard();

    }
    private void clearBoard(){
        for(int i=0; i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=null;
            }
        }
    }
    private void initializeBoard(){
        //Black
        //Pawn
        for(int i=0;i<board[0].length;i++){
            board[1][i]=new Pawn(i,1,0);
        }
        //Rook
        board[0][0]=new Rook(0,0,0);
        board[0][board[0].length-1]=new Rook(0,board[0].length-1,0);
        //Knight
        board[0][1]=new Knight(0,1,0);
        board[0][board[0].length-2]=new Knight(0,board[0].length-2,0);
        //Bishop
        board[0][2]=new Bishop(0,2,0);
        board[0][board[0].length-3]=new Bishop(0,board[0].length-3,0);


        //White
        //Pawn
        for(int i=0;i<board[0].length;i++){
            board[size-2][i]=new Pawn(i,size-2,1);
        }
        //Rook
        board[size-1][0]=new Rook(size-1,0,0);
        board[size-1][board[0].length-1]=new Rook(size-1,board[0].length-1,0);
        //Knight
        board[size-1][1]=new Knight(size-1,1,0);
        board[size-1][board[0].length-2]=new Knight(size-1,board[0].length-2,0);
        //Bishop
        board[size-1][2]=new Bishop(size-1,2,0);
        board[size-1][board[0].length-3]=new Bishop(size-1,board[0].length-3,0);
        addManagerToAllPiece();
    }
    private void printBoard(){
        for(int i=0;i<size;i++){
            System.out.println(board[4][i]);
        }
    }
    public List<Point2D> getAvailableMove(int x, int y){
        return board[y][x].availableMove(size);
    }
    public List<Point2D> getAvailableCapture(int x, int y){
        List<Point2D> list= new ArrayList<>();
        for(Point2D point2D:board[y][x].availableCapture(size)){
            if(board[(int)point2D.getY()][(int)point2D.getX()]!=null){
                if(board[y][x].getOwner()!=board[(int)point2D.getY()][(int)point2D.getX()].getOwner()){
                    list.add(point2D);
                }

            }
        }

        return board[y][x].availableCapture(size);
    }

    public boolean move(int x1, int y1, int x2, int y2){
        boolean canMove=false;
        for(Point2D point2D:board[y1][x1].availableMove(size)){
            if(point2D.getX()==x2&&point2D.getY()==y2){
                canMove=true;
            }
        }
        if(canMove){
            board[y1][x1].move(new Point2D(x2,y2));
            board[y2][x2]=board[y1][x1];
            board[y1][x1]=null;
        }
        return canMove;

    }
    private void addManagerToAllPiece(){
        for (int i =0; i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!=null){
                    board[i][j].setManager(this);
                }
            }
        }
    }
    public GenericChessPiece getPieceAt(int x, int y){
        return board[y][x];
    }
}
