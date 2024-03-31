package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Controller {
    protected Block tetro;
    ArrayList<GUIListener> GUIListener;
    public Controller(Block tetro){
        this.tetro=tetro;
    }
    public void changeTarget(Block tetro){
        this.tetro=tetro;
    }

    public void listenForKeyPressed() {
    }
}
