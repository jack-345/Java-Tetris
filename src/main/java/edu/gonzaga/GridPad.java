package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class GridPad implements GameListener {
    GridBlock[][] gridBlocks;
    Line lines;
    Integer height;
    Integer width;
    Block blockOnControl;
    ArrayList<GUIListener> guiListeners;

    public GridPad(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        gridBlocks = new GridBlock[height][width];
        guiListeners = new ArrayList<GUIListener>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gridBlocks[i][j] = new GridBlock(new Point(j, i));
            }
        }

    }
    //Export the game interface on the command line.

    public Block spawnABlock(Point spawnPoint) {
        blockOnControl = new BlockI(gridBlocks, spawnPoint);
        blockOnControl.addToGameListeners(this);
        return blockOnControl;
    }

    public void addABlock(Block ter) {
        blockOnControl = ter;
    }

    public GridBlock[][] getGridBlocks() {
        return gridBlocks;
    }

    //This movingCheck is used to detect the direction in which the square can move.
    //It is implemented by returning an array of 3 booleans. The array consists of {left,down,right}.
    //If the square can move down, but not left or right, then the value of the boolean array is {false,true,false}.
    public Boolean[] movingCheck() {
        Boolean left = true;
        Boolean down = true;
        Boolean right = true;
        for (Point p : blockOnControl.getShape()) {
            if (p.x <= 0) {
                left = false;
            } else if (gridBlocks[p.y][p.x - 1].isLocked()) {
                left = false;
            }
            if (p.x >= width - 1) {
                right = false;
            } else if (gridBlocks[p.y][p.x + 1].isLocked()) {
                right = false;
            }
            if (p.y >= height - 1) {
                down = false;
            } else if (gridBlocks[p.y + 1][p.x].isLocked()) {
                down = false;
            }

        }
        return new Boolean[]{left, down, right};
    }

    public boolean rotateCheck(int direction, Point center) {
        ArrayList<Point> shape = blockOnControl.getShape();
        if (blockOnControl.getType() == 0) {
            return false;
        }
        if (direction > 0) {
            for (int r = 0; r < direction; r++) {
                for (int i = 0; i < shape.size(); i++) {
                    Point p = shape.get(i);
                    int x = center.x + center.y - p.y;
                    int y = center.y - center.x + p.x;
                    if (x < 0 || x >= width) {
                        return false;
                    }
                }
            }
        } else if (direction < 0) {
            for (int r = 0; r < Math.abs(direction); r++) {
                for (int i = 0; i < shape.size(); i++) {
                    Point p = shape.get(i);
                    int x = center.x - center.y + p.y;
                    int y = center.y + center.x - p.x;
                    if (x < 0 || x >= width) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Block getBlockOnControl() {
        return blockOnControl;
    }

    public Boolean[] movingCheck(Block tetroOnControl) {
        Boolean left = true;
        Boolean down = true;
        Boolean right = true;
        for (Point p : tetroOnControl.getShape()) {
            if (p.x <= 0) {
                left = false;
            } else if (gridBlocks[p.y][p.x - 1].isLocked()) {
                left = false;
            }
            if (p.x >= width - 1) {
                right = false;
            } else if (gridBlocks[p.y][p.x + 1].isLocked()) {
                right = false;
            }
            if (p.y >= height - 1) {
                down = false;
            } else if (gridBlocks[p.y + 1][p.x].isLocked()) {
                down = false;
            }

        }
        return new Boolean[]{left, down, right};
    }

    public void lineCheck() {
        // Iterate through each row of the grid
        for (int y = height - 1; y >= 0; y--) { // Start from the bottom row
            boolean lineFilled = true;
            // Check each block in the current row
            for (int x = 0; x < width; x++) {
                if (!gridBlocks[y][x].isLocked()) {
                    lineFilled = false;
                    break; // No need to check further if any block in the row is not locked
                }
            }
            // If all blocks in the row are locked, the line is filled
            if (lineFilled) {
                clearLine(y); // Implement this method to clear the filled line
                y++; // Since a line is cleared, decrement y to recheck the current row

            }
        }
    }

    public boolean lineCheckMZ(Integer line) {
        boolean lineFilled = true;
        // Check each block in the current row
        for (int x = 0; x < width; x++) {
            if (!gridBlocks[line][x].isLocked() || gridBlocks[line][x].isDeleted()) {
                lineFilled = false;
                break; // No need to check further if any block in the row is not locked
            }
        }
        return lineFilled;
    }

    public void clearLine(int rowIndex) {
        // Remove all blocks from the specified row
        for (int x = 0; x < width; x++) {
            // gridBlocks[rowIndex+1][x].flashBlock(Color.white, 50);
            gridBlocks[rowIndex][x].setLock(false); // Unlock the block
            gridBlocks[rowIndex][x].setFill(false); // Empty the block
            gridBlocks[rowIndex][x].setDeleted(false);

        }

        // Move down all blocks above the cleared row
        for (int y = rowIndex - 1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                GridBlock blockAbove = gridBlocks[y][x];
                GridBlock blockBelow = gridBlocks[y + 1][x];
                blockBelow.setLock(blockAbove.isLocked()); // Move down the lock state
                blockBelow.setFill(blockAbove.isFill()); // Move down the fill state
                blockBelow.setColor(blockAbove.getColor()); // Move down the color
                // Clear the block above
                blockAbove.setLock(false);
                blockAbove.setFill(false);
            }
        }
    }

    public GridBlock getBlock(int x, int y) {
        return gridBlocks[y][x];
    }

    public void addGUIListener(GUIListener guiListener) {
        guiListeners.add(guiListener);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void notifyGUIListeners() {
        for (GUIListener listener : guiListeners) {
            listener.update();
        }
    }

    @Override
    public void updateGame() {
        notifyGUIListeners();
    }

}
