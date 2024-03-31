package edu.gonzaga;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController extends Controller {
    private JFrame frame;
    public KeyboardController(JFrame frame,GridPad gridPad){
        super(gridPad);
        this.frame = frame;
    }

    public void moveLeft(){
        controlBlock.moveLeft();
    }

    public void moveRight() {
        controlBlock.moveRight();
    }

    public void moveDown(){
        controlBlock.step();
    }
    public void rotate(int direction){controlBlock.rotate(direction);}
    public void listenForKeyPressed(){
        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                // Check which key is pressed and call corresponding methods
                if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
                    if(gridPad.movingCheck(controlBlock)[0]) {
                        moveLeft();
                    }
                } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
                    if(gridPad.movingCheck(controlBlock)[2]) {
                        moveRight();
                    }
                } else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_K) {
                    rotate(-1);
                } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_L){
                    rotate(1);
                }
                else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
                    if(gridPad.movingCheck(controlBlock)[1]) {
                        moveDown();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
    }

}
