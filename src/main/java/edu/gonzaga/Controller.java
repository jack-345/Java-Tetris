package edu.gonzaga;

import java.util.ArrayList;

public class Controller {
    Tetrominoes tetro;
    ArrayList<GUIListener> GUIListener;
    public Controller(Tetrominoes tetro){
        this.tetro=tetro;
    }
    public void changeTarget(Tetrominoes tetro){
        this.tetro=tetro;
    }
    public void notifyListeners(){

    }
}
