package edu.gonzaga;

import java.awt.*;

public class Block{
    private Point upperLeft;
    private Point lowerLeft;
    private Point upperRight;
    private Point lowerRight;
    private boolean isFill;
    private boolean isLocked;
    public Block(Point uL){
        upperLeft=uL;
    }
    public Block(Point uL,Point lL,Point uR,Point lR){
        createBlock(uL,lL,uR,lR);
    }
    public void createBlock(Point uL,Point lL,Point uR,Point lR){
        upperLeft=uL;
        lowerLeft=lL;
        upperRight=uR;
        lowerRight=lR;
    }

    public void setFill(boolean fill) {
        isFill = fill;
    }

    public boolean isFill() {
        return isFill;
    }
    public void checkBlock(Tetrominoes ter){

    }

    public boolean isLocked() {
        return isLocked;
    }
    public void setLock(boolean lock){
        isLocked=lock;
    }
    public void updateBlock(Tetrominoes ter){
        checkBlock(ter);
    }
}
