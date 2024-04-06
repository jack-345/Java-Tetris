package edu.gonzaga;

import java.util.ArrayList;

public abstract class Controller {
    protected Block controlBlock;
    protected GridPad gridPad;
    protected TetrisGame game;

    public Controller(GridPad gridPad) {
        this.controlBlock = gridPad.blockOnControl;
        this.gridPad = gridPad;
    }

    public void changeTarget(Block tetro) {
        this.controlBlock = tetro;
    }

    public void listenForKeyPressed() {
    }
    public void stopListen(){

    }
    public void continueListen(){

    }
}
