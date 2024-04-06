package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public abstract class Block {
    //This bias means spawn location.
    protected Point bias;
    protected Color color;
    //This stores grid information. I know this is a bit of a performance drain, so I'll modify it in the future.
    protected GridBlock[][] gridBlockField;
    //Each block consists of 4 gridBlocks, and this array is used to hold information about the gridBlocks used to form the blok.
    protected ArrayList<Point> shape;
    //The gameListener is used to update game information such as display and score. I only used it here to update the display.
    protected ArrayList<GameListener> gameListeners;

    //constructor, enter the grid and birth point to create a new block.
    public Block(GridBlock[][] gridBlockField, Point spawnPoint, Color color) {
        gameListeners = new ArrayList<GameListener>();
        this.gridBlockField = gridBlockField;
        bias = spawnPoint;
        this.color = color;
    }

    public abstract void rotate(int direction);

    public void rotate(int direction, Point center) {
        for (Point p : shape) {
            gridBlockField[p.y][p.x].setFill(false);
            gridBlockField[p.y][p.x].setColor(new Color(255, 255, 255));

        }
        if (direction > 0) {
            for (int r = 0; r < direction; r++) {
                for (int i = 0; i < shape.size(); i++) {
                    Point p = shape.get(i);
                    int x = center.x + center.y - p.y;
                    int y = center.y - center.x + p.x;
                    shape.set(i, new Point(x, y));
                }
            }
        } else if (direction < 0) {
            for (int r = 0; r < Math.abs(direction); r++) {
                for (int i = 0; i < shape.size(); i++) {
                    Point p = shape.get(i);
                    int x = center.x - center.y + p.y;
                    int y = center.y + center.x - p.x;
                    shape.set(i, new Point(x, y));
                }
            }
        } else {
            return;
        }
        for (Point p : shape) {
            gridBlockField[p.y][p.x].setFill(true);
            gridBlockField[p.y][p.x].setColor(color);
        }
        notifyGameListeners();
    }

    //public void rotateCountClockwise(){}
    public void moveLeft() {
        for (Point p : shape) {
            gridBlockField[p.y][p.x].setFill(false);
            gridBlockField[p.y][p.x].setColor(new Color(255, 255, 255));
        }
        for (Point p : shape) {
            p.setLocation(p.x - 1, p.y);
            gridBlockField[p.y][p.x].setFill(true);
            gridBlockField[p.y][p.x].setColor(color);
        }
        notifyGameListeners();
    }

    public void moveRight() {
        for (Point p : shape) {
            gridBlockField[p.y][p.x].setFill(false);
            gridBlockField[p.y][p.x].setColor(new Color(255, 255, 255));
        }
        for (Point p : shape) {
            p.setLocation(p.x + 1, p.y);
            gridBlockField[p.y][p.x].setFill(true);
            gridBlockField[p.y][p.x].setColor(color);
        }
        notifyGameListeners();
    }

    //Step means to move down. The listener is notified every time it moves to update the display.
    public void step() {
        for (Point p : shape) {
            gridBlockField[p.y][p.x].setFill(false);
            gridBlockField[p.y][p.x].setColor(new Color(255, 255, 255));
        }
        for (Point p : shape) {
            p.setLocation(p.x, p.y + 1);
            gridBlockField[p.y][p.x].setFill(true);
            gridBlockField[p.y][p.x].setColor(color);
        }
        notifyGameListeners();
    }

    public void addToGameListeners(GameListener listener) {
        gameListeners.add(listener);
    }

    public void notifyGameListeners() {
        for (GameListener listener : gameListeners) {
            listener.updateGame();
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void notifyGUIListeners() {

    }

    public ArrayList<Point> getShape() {
        return shape;
    }

    public abstract Point getCenter();

    public abstract int getType();

    public void deleted() {

    }

    //The lock state means that whenever a square is locked, that means it stops moving. One version means touching other squares or touching the bottom.
    public void lock() {
        for (Point p : shape) {
            gridBlockField[p.y][p.x].setLock(true);
        }
    }
    public Point getBias(){
        return bias;
    }
}
