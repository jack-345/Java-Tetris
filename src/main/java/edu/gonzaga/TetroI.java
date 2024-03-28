package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class TetroI extends Tetrominoes{
    public TetroI(Block[][] blocks,Point spawnPoint){
        super(blocks,spawnPoint);
        shape = new ArrayList<Point>();
        shape.add(new Point(bias.x, bias.y));
        shape.add(new Point(bias.x,1+bias.y));
        shape.add(new Point(bias.x,2+bias.y));
        shape.add(new Point(bias.x,3+bias.y));

    }

    @Override
    public Point getCenter() {
        return null;
    }
}
