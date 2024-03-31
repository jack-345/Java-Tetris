package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class GridPad implements GameListener{
    GridBlock[][] gridBlocks;
    Line lines;
    Integer height;
    Integer width;
    Block blockOnControl;
    ArrayList<GUIListener> guiListeners;
    public GridPad(Integer width, Integer height){
        this.width=width;
        this.height=height;
        gridBlocks =new GridBlock[height][width];
        guiListeners=new ArrayList<GUIListener>();
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                gridBlocks[i][j]=new GridBlock(new Point(j,i));
            }
        }

    }
    //Export the game interface on the command line.

    public Block spawnABlock(Point spawnPoint){
        blockOnControl = new BlockI(gridBlocks,spawnPoint);
        blockOnControl.addToGameListeners(this);
        return blockOnControl;
    }
    public void addABlock(Block ter){
        blockOnControl =ter;
    }
    public GridBlock[][] getGridBlocks(){
        return gridBlocks;
    }
    //This movingCheck is used to detect the direction in which the square can move.
    //It is implemented by returning an array of 3 booleans. The array consists of {left,down,right}.
    //If the square can move down, but not left or right, then the value of the boolean array is {false,true,false}.
    public Boolean[] movingCheck(){
        Boolean left=true;
        Boolean down=true;
        Boolean right=true;
        for(Point p: blockOnControl.getShape()){
            if(p.x<=0){
                left=false;
            }
            else if(gridBlocks[p.y][p.x-1].isLocked()){
                left=false;
            }
            if(p.x>=width-1){
                right=false;
            }
            else if(gridBlocks[p.y][p.x+1].isLocked()){
                right=false;
            }
            if(p.y>=height-1){
                down=false;
            }
            else if(gridBlocks[p.y+1][p.x].isLocked()){
                down=false;
            }

        }
        return new Boolean[]{left,down,right};
    }
    public boolean rotateCheck(int direction, Point center){
        ArrayList<Point> shape = blockOnControl.getShape();
        if(blockOnControl.getType()==0){
            return false;
        }
        if(direction>0) {
            for (int r = 0; r < direction; r++) {
                for (int i = 0; i < shape.size(); i++) {
                    Point p = shape.get(i);
                    int x = center.x + center.y - p.y;
                    int y = center.y - center.x + p.x;
                    if(x<0||x>=width){
                        return false;
                    }
                }
            }
        }
        else if(direction<0) {
            for (int r = 0; r < Math.abs(direction); r++) {
                for (int i = 0; i < shape.size(); i++) {
                    Point p = shape.get(i);
                    int x = center.x - center.y + p.y;
                    int y = center.y + center.x - p.x;
                    if(x<0||x>=width){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public Block getBlockOnControl(){
        return blockOnControl;
    }
    public Boolean[] movingCheck(Block tetroOnControl){
        Boolean left=true;
        Boolean down=true;
        Boolean right=true;
        for(Point p:tetroOnControl.getShape()){
            if(p.x<=0){
                left=false;
            }
            else if(gridBlocks[p.y][p.x-1].isLocked()){
                left=false;
            }
            if(p.x>=width-1){
                right=false;
            }
            else if(gridBlocks[p.y][p.x+1].isLocked()){
                right=false;
            }
            if(p.y>=height-1){
                down=false;
            }
            else if(gridBlocks[p.y+1][p.x].isLocked()){
                down=false;
            }

        }
        return new Boolean[]{left,down,right};
    }
    public GridBlock getBlock(int x, int y){
        return gridBlocks[y][x];
    }
    public void addGUIListener(GUIListener guiListener){
        guiListeners.add(guiListener);
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void notifyGUIListeners(){
        for(GUIListener listener:guiListeners){
            listener.update();
        }
    }
    @Override
    public void updateGame() {
     
        notifyGUIListeners();
    }



}
