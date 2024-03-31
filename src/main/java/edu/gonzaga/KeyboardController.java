package edu.gonzaga;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController extends Controller {
    private JFrame frame;
    private Block controlBlock;
    public KeyboardController(JFrame frame, Block block){
        super(null);
        this.frame = frame;
        this.controlBlock = block;
    }

    public void moveLeft(){
        controlBlock.moveLeft();
    }

    public void moveRight() {
        controlBlock.moveRight();
    }

    public void moveDown(){
        controlBlock.moveDown();
    }

    public void listenForKeyPressed(){
        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                // Check which key is pressed and call corresponding methods
                if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
                    moveLeft();
                } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
                    moveRight();
                } else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
                    //rotate();
                } else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
                    moveDown();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
    }

}
