package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Controller {
    protected Block controlBlock;
    protected GridPad gridPad;
    ArrayList<GUIListener> GUIListener;
    public Controller(Block tetro,GridPad gridPad){
        this.controlBlock=tetro;
        this.gridPad=gridPad;
    }
    public void changeTarget(Block tetro){
        this.controlBlock=tetro;
    }

    public void listenForKeyPressed() {
    }
}
