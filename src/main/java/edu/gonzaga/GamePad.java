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
        tetroOnControl.step();
    }
    public void spawnATetro(){
        tetroOnControl = new TetroI(blocks);
    }
    public Block[][] getBlocks(){
        return blocks;
    }
}
