package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class testBlockRotateLeft extends Block {
    public testBlockRotateLeft(GridBlock[][] gridBlockField, Point spawnPoint) {
        super(gridBlockField, spawnPoint, new Color(0, 0, 255));
        shape = new ArrayList<Point>();
        shape.add(new Point( bias.x-1, bias.y));
        shape.add(new Point(bias.x, bias.y));
        shape.add(new Point(1 + bias.x, bias.y));
        shape.add(new Point(1 + bias.x, 1 + bias.y));
    }

    @Override
    public void rotate(int direction) {
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
