package edu.gonzaga;

import java.awt.*;

public class GridPad implements GameListener{
    GridBlock[][] gridBlocks;
    Line lines;
    Integer height;
    Integer width;
    Block tetroOnControl;
    public GridPad(Integer width, Integer height){
        this.width=width;
        this.height=height;
        gridBlocks =new GridBlock[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                gridBlocks[i][j]=new GridBlock(new Point(j,i));
            }
        }

    }
    //Export the game interface on the command line.
    @Override
    public void updateGame() {
        for(GridBlock[] a: gridBlocks){
            for(GridBlock b:a){
                if(b.isFill())
                    System.out.print('#');
                else{
                    System.out.print(' ');
                }
            }
            System.out.println("");
        }
        System.out.println("--------------------");
    }
    public Block spawnABlock(Point spawnPoint){
        tetroOnControl = new BlockI(gridBlocks,spawnPoint);
        tetroOnControl.addToGameListeners(this);
        return tetroOnControl;
    }
    public void addABlock(Block ter){
        tetroOnControl=ter;
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
}
