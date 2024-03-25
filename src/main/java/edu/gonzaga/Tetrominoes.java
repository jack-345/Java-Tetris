import java.awt.*;
import java.util.ArrayList;

public abstract class Tetrominoes {
    protected int color;
    protected Point position;
    protected ArrayList<Point> shape;
    protected ArrayList<GameListener> gameListeners;
    public void rotateClockwise(){}
    public void rotateCountClockwise(){}
    public  void moveLeft(){}
    public void moveRight(){}
    public void moveDown(){}

    public void setPosition(Point position) {
        this.position = position;
    }
    public abstract Point getCenter();
    public Point getPosition() {
        return position;
    }
    public void notifyGameListeners(){

    }
    public void notifyGUIListeners(){

    }
    public void deleted(){

    }
}
