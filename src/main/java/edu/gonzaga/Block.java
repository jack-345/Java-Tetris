package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public abstract class Block {
    protected Point bias;
    protected int color;
    protected Point position;
    protected GridBlock[][] gridBlockField;
    protected ArrayList<Point> shape;
    protected ArrayList<GameListener> gameListeners;
    public void rotateClockwise(){}
    public void rotateCountClockwise(){}
    public  void moveLeft(){
        for(Point p:shape){
            gridBlockField[p.y][p.x].setFill(false);
        }
        for(Point p:shape){
            p.setLocation(p.x-1,p.y);
            gridBlockField[p.y][p.x].setFill(true);
        }
        notifyGameListeners();
    }
    public void moveRight(){
        for(Point p:shape){
            gridBlockField[p.y][p.x].setFill(false);
        }
        for(Point p:shape){
            p.setLocation(p.x+1,p.y);
            gridBlockField[p.y][p.x].setFill(true);
        }
        notifyGameListeners();
    }
    public void moveDown(){}
    public Block(GridBlock[][] gridBlockField, Point spawnPoint){
        gameListeners=new ArrayList<GameListener>();
        this.gridBlockField = gridBlockField;
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
            gridBlockField[p.y][p.x].setFill(false);
        }
        for(Point p:shape){
            p.setLocation(p.x,p.y+1);
            gridBlockField[p.y][p.x].setFill(true);
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
    public ArrayList<Point> getShape(){
        return shape;
    }
    public void deleted(){

    }
    public void lock(){
        for(Point p:shape){
            gridBlockField[p.y][p.x].setLock(true);
        }
    }
}
