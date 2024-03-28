package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class TetroO extends Tetrominoes{
    public TetroO(Block[][] blocks,Point spawnPoint){
        super(blocks,spawnPoint);
        shape = new ArrayList<Point>();
        shape.add(new Point(bias.x, bias.y));
        shape.add(new Point(bias.x,1+bias.y));
        shape.add(new Point(1+bias.x,bias.y));
        shape.add(new Point(1+bias.x,1+bias.y));

    }

    @Override
    public Point getCenter() {
        return null;
    }
}
