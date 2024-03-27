package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public abstract class Tetrominoes {
    protected Point bias;
    protected int color;
    protected Point position;
    protected Block[][] blockField;
    protected ArrayList<Point> shape;
    protected ArrayList<GameListener> gameListeners;
    public void rotateClockwise(){}
    public void rotateCountClockwise(){}
    public  void moveLeft(){}
    public void moveRight(){}
    public void moveDown(){}
    public Tetrominoes(Block[][] blockField,Point spawnPoint){
        gameListeners=new ArrayList<GameListener>();
        this.blockField=blockField;
        bias=spawnPoint;
    }
    public void setPosition(Point position) {
        this.position = position;
    }
    public abstract Point getCenter();
    public Point getPosition() {
        return position;
    }
    public void step(){
        for(Point p:shape){
            blockField[p.y][p.x].setFill(false);
        }
        for(Point p:shape){
            p.setLocation(p.x,p.y+1);
            blockField[p.y][p.x].setFill(true);
        }
        notifyGameListeners();
    }
    public void addToGameListeners(GameListener listener){
        gameListeners.add(listener);
    }
    public void notifyGameListeners(){
        for(GameListener listener:gameListeners){
            listener.updateGame();
        }
    }
    public void notifyGUIListeners(){

    }
    public void deleted(){

    }
}
