package edu.gonzaga;

public class BlockEvent implements Event{
    static int MOVE_LEFT = -2;
    static int MOVE_RIGHT = 2;
    static int MOVE_DOWN = 0;
    static  int ROTATE_LEFT = -1;
    static int ROTATE_RIGHT = 1;
    private final int event;
    public BlockEvent(int event) {
        this.event = event;
    }
    public int getEvent() {
        return event;
    }
}
