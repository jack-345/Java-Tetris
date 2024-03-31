package edu.gonzaga;

import java.util.ArrayList;

public class Controller {
    Block tetro;
    ArrayList<GUIListener> GUIListener;
    public Controller(Block tetro){
        this.tetro=tetro;
    }
    public void changeTarget(Block tetro){
        this.tetro=tetro;
    }
    public void notifyListeners(){

    }
}
