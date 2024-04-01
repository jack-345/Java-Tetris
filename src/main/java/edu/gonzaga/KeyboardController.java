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
                    if(gridPad.movingCheck()[0]) {
                        moveLeft();
                    }
                } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
                    if(gridPad.movingCheck()[2]) {
                        moveRight();
                    }
                } else if (keyCode == KeyEvent.VK_Z || keyCode == KeyEvent.VK_K) {
                    if(gridPad.rotateCheck(-1,controlBlock.getCenter())) {
                        rotate(-1);
                    }
                } else if (keyCode == KeyEvent.VK_X || keyCode == KeyEvent.VK_L){
                    if(gridPad.rotateCheck(-1,controlBlock.getCenter())) {
                        rotate(1);
                    }

                }
                else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
                    if(gridPad.movingCheck()[1]) {
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
