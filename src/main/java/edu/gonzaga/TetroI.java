import java.awt.*;
import java.util.ArrayList;

public class TetroI extends Tetrominoes{
    public TetroI(Block[][] blocks){
        super(blocks);
        shape = new ArrayList<Point>();
        shape.add(new Point(0,1));
        shape.add(new Point(0,2));
        shape.add(new Point(0,3));
        shape.add(new Point(0,4));
        blockField[1][0].setFill(true);
        blockField[2][0].setFill(true);
        blockField[3][0].setFill(true);
        blockField[4][0].setFill(true);
    }

    @Override
    public Point getCenter() {
        return null;
    }
}
