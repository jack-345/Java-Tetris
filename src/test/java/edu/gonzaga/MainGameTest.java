package edu.gonzaga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;


import javax.swing.*;
import java.awt.*;



public class MainGameTest {
    //universal setup
    GridPad gridPad = new GridPad(10, 40);
    JFrame testFrame = new JFrame();
    KeyboardController testController = new KeyboardController(testFrame,  gridPad);

    @Test
    void alwaysTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    void buttonPressedDownWorks() {
        BlockL testBlockL = new BlockL(gridPad.getGridBlocks(), new Point(4, 0));
        //ensures the block has moved down in all points by checking center
        BlockL verifyBlock = new BlockL(gridPad.getGridBlocks(), new Point(4, 1));
        testController.changeTarget(testBlockL);
        gridPad.addABlock(testBlockL);
        // Simulate the press of the down key
        KeyEvent downKeyEvent = new KeyEvent(new JPanel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);
        testController.keyPressed(downKeyEvent);

        Assertions.assertEquals(testBlockL.getCenter(), verifyBlock.getCenter());

    }

    @Test
    void buttonPressedLeftWorks() {
        BlockL testBlockL = new BlockL(gridPad.getGridBlocks(), new Point(4, 0));
        //ensures the block has moved down in all points by checking center
        BlockL verifyBlock = new BlockL(gridPad.getGridBlocks(), new Point(3, 0));
        testController.changeTarget(testBlockL);
        gridPad.addABlock(testBlockL);
        // Simulate the press of the down key
        KeyEvent leftKeyEvent = new KeyEvent(new JPanel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        testController.keyPressed(leftKeyEvent);

        Assertions.assertEquals(testBlockL.getCenter(), verifyBlock.getCenter());

    }

    @Test
    void buttonPressedRightWorks() {
        BlockL testBlockL = new BlockL(gridPad.getGridBlocks(), new Point(4, 0));
        //ensures the block has moved down in all points by checking center
        BlockL verifyBlock = new BlockL(gridPad.getGridBlocks(), new Point(5, 0));
        testController.changeTarget(testBlockL);
        gridPad.addABlock(testBlockL);
        // Simulate the press of the down key
        KeyEvent rightKeyEvent = new KeyEvent(new JPanel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        testController.keyPressed(rightKeyEvent);

        Assertions.assertEquals(testBlockL.getCenter(), verifyBlock.getCenter());
    }

    @Test
    void buttonTurnedClockwiseWorks() {
        BlockL testBlockL = new BlockL(gridPad.getGridBlocks(), new Point(4, 0));
        //ensures the block has rotated by checking center
        testBlockRotateLeft verifyBlock = new testBlockRotateLeft(gridPad.getGridBlocks(), new Point(4, 1));
        testController.changeTarget(testBlockL);
        gridPad.addABlock(testBlockL);
        // Simulate the press of the down key
        KeyEvent zKeyEvent = new KeyEvent(new JPanel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_Z, KeyEvent.CHAR_UNDEFINED);
        testController.keyPressed(zKeyEvent);

        Assertions.assertEquals(testBlockL.getCenter(), verifyBlock.getCenter());
    }

    @Test
    void buttonTurnedCounterClockwiseWorks() {}
}
