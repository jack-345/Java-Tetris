package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class TetroS extends Tetrominoes{
    public TetroS(Block[][] blocks){
        super(blocks);
        shape = new ArrayList<Point>();
        shape.add(new Point(0,0));
        shape.add(new Point(0,1));
        shape.add(new Point(1,0));
        shape.add(new Point(1,1));
        blockField[0][0].setFill(true);
        blockField[1][0].setFill(true);
        blockField[0][1].setFill(true);
        blockField[1][1].setFill(true);
    }
    @Override
    public Point getCenter() {
        return null;
    }
}
