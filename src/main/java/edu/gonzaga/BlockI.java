package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class BlockI extends Block {
    public BlockI(GridBlock[][] gridBlocks, Point spawnPoint){
        super(gridBlocks,spawnPoint);
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
