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
        //ensures the block has moved down in all points
        BlockL verifyBlock = new BlockL(gridPad.getGridBlocks(), new Point(4, 1));

        // Simulate the press of the down key
        KeyEvent downKeyEvent = new KeyEvent(new JPanel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);
        testController.keyPressed(downKeyEvent);

        Assertions.assertEquals(testBlockL, verifyBlock);

    }

    @Test
    void buttonPressedUpWorks() {}

    @Test
    void buttonPressedLeftWorks() {}

    @Test
    void buttonPressedRightWorks() {}

    @Test
    void buttonTurnedClockwiseWorks() {}

    @Test
    void buttonTurnedCounterClockwiseWorks() {}
}
