package edu.gonzaga;

import java.awt.*;

public class GamePad implements GameListener{
    Block[][] blocks;
    Line lines;
    Integer height;
    Integer width;
    Tetrominoes tetroOnControl;
    public GamePad(Integer width,Integer height){
        this.width=width;
        this.height=height;
        blocks=new Block[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                blocks[i][j]=new Block(new Point(j,i));
            }
        }

    }
    @Override
    public void updateGame() {
        for(Block[] a:blocks){
            for(Block b:a){
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
    public Tetrominoes spawnATetro(Point spawnPoint){
        tetroOnControl = new TetroI(blocks,spawnPoint);
        tetroOnControl.addToGameListeners(this);
        return tetroOnControl;
    }
    public void addATetro(Tetrominoes ter){
        tetroOnControl=ter;
    }
    public Block[][] getBlocks(){
        return blocks;
    }
    public Boolean[] movingCheck(){
        Boolean left=true;
        Boolean down=true;
        Boolean right=true;
        for(Point p:tetroOnControl.getShape()){
            if(p.x<=0){
                left=false;
            }
            else if(blocks[p.y][p.x-1].isLocked()){
                left=false;
            }
            if(p.x>=width-1){
                right=false;
            }
            else if(blocks[p.y][p.x+1].isLocked()){
                right=false;
            }
            if(p.y>=height-1){
                down=false;
            }
            else if(blocks[p.y+1][p.x].isLocked()){
                down=false;
            }

        }
        return new Boolean[]{left,down,right};
    }
}
