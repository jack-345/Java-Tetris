package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class BlockS extends Block{
    public BlockS(GridBlock[][] gridBlockField, Point spawnPoint) {
        super(gridBlockField, spawnPoint);
        shape = new ArrayList<Point>();
        shape.add(new Point(1+bias.x, bias.y));
        shape.add(new Point(2+bias.x,bias.y));
        shape.add(new Point(bias.x,1+bias.y));
        shape.add(new Point(1+bias.x,1+bias.y));
    }
}
