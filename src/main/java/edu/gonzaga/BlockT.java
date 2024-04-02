package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class BlockT extends Block {
    public BlockT(GridBlock[][] gridBlockField, Point spawnPoint) {
        super(gridBlockField, spawnPoint, new Color(128, 0, 128));
        shape = new ArrayList<Point>();
        shape.add(new Point(bias.x, bias.y));
        shape.add(new Point(1 + bias.x, bias.y));
        shape.add(new Point(2 + bias.x, bias.y));
        shape.add(new Point(1 + bias.x, 1 + bias.y));
    }

    @Override
    public void rotate(int direction) {
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
