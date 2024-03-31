package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class BlockJ extends Block{
    @Override
    public void rotate(int direction) {;
        super.rotate(direction,shape.get(1));
    }

    public BlockJ(GridBlock[][] gridBlockField, Point spawnPoint) {
        super(gridBlockField, spawnPoint);
        shape = new ArrayList<Point>();
        shape.add(new Point(1+bias.x, bias.y));
        shape.add(new Point(1+bias.x,1+bias.y));
        shape.add(new Point(1+bias.x,2+bias.y));
        shape.add(new Point(bias.x,2+bias.y));
    }

}
