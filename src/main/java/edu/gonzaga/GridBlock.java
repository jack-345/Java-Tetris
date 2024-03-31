package edu.gonzaga;

import java.awt.*;

public class GridBlock {
    private Color color;
    private Point upperLeft;
    private Point lowerLeft;
    private Point upperRight;
    private Point lowerRight;
    //If the square is filled, it means a block is passing by.
    private boolean isFill;
    //The lock state means that the gridBlock is locked. It means that the blocks it consists of have hit other blocks or have fallen to the bottom.
    private boolean isLocked;
    //Create a new block by typing in the coordinates of the upper left corner of the gridblock, this is reserved for the gui and is not currently used, it can be any value.
    public GridBlock(Point uL){
        upperLeft=uL;
        color = new Color(255,255,255);
    }

    public GridBlock(Point uL, Point lL, Point uR, Point lR){
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
    public void checkBlock(Block ter){

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isLocked() {
        return isLocked;
    }
    public void setLock(boolean lock){
        isLocked=lock;
    }
    public void updateBlock(Block ter){
        checkBlock(ter);
    }
}
