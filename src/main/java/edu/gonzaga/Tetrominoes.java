import java.awt.*;
import java.util.ArrayList;

public abstract class Tetrominoes {
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
    public Tetrominoes(Block[][] blockField){
        this.blockField=blockField;
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
    }
    public void notifyGameListeners(){

    }
    public void notifyGUIListeners(){

    }
    public void deleted(){

    }
}
