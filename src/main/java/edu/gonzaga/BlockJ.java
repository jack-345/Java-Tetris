package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class BlockJ extends Block {
    public BlockJ(GridBlock[][] gridBlockField, Point spawnPoint) {
        super(gridBlockField, spawnPoint, new Color(0, 0, 255));
        shape = new ArrayList<Point>();
        shape.add(new Point(1 + bias.x, bias.y));
        shape.add(new Point(1 + bias.x, 1 + bias.y));
        shape.add(new Point(1 + bias.x, 2 + bias.y));
        shape.add(new Point(bias.x, 2 + bias.y));
    }

    @Override
    public void rotate(int direction) {
        ;
        super.rotate(direction, shape.get(1));
    }

    @Override
    public Point getCenter() {
        return shape.get(1);
    }

    @Override
    public int getType() {
        return 5;
    }

}
