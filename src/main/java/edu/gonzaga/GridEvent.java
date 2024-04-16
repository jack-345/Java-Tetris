package edu.gonzaga;

public class GridEvent implements Event{
    static int COLOR_CHANGE=0;
    static int LOCK=1;
    static int UNLOCK=2;
    static int FILL=3;
    static int UNFILL=4;
    static int DELETED=5;
    static int ON_DELETE=6;
    private final int event;
    GridEvent(int event) {
        this.event = event;
    }
    public int getEvent() {
        return event;
    }
}
