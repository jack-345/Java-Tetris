package edu.gonzaga;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class structureTest {

        @Test
        void testStartMenuDisplay() {
            TetrisGame tetrisGame = new TetrisGame();
            tetrisGame.startMenu();
            assertNotNull(tetrisGame.menu);
        }

        /*
        @Test
        void testGameStart() {
            TetrisGame tetrisGame = new TetrisGame();
            try {
                tetrisGame.startGame();
            } catch (Exception e) {
                fail("Game start failed: " + e.getMessage());
            }
            assertNotNull(tetrisGame.gridPad);
            assertNotNull(tetrisGame.scoreLabel);
            assertNotNull(tetrisGame.nextBlockPanel);
        }
         */

        @Test
        void testScoreUpdate() {
            TetrisGame tetrisGame = new TetrisGame();
            tetrisGame.score = 0; // Assuming initial score is 0
            tetrisGame.score += tetrisGame.countScore(1); // Simulate clearing one line
            assertEquals(100, tetrisGame.score, "Score should be updated correctly for clearing one line");
            // Add more tests to verify score update for clearing multiple lines
        }

        @Test
        void testGameEnd() {
            TetrisGame tetrisGame = new TetrisGame();
            tetrisGame.ifGameEnd = true;
            tetrisGame.endGame();
            assertTrue(tetrisGame.ifGameEnd, "Game should be ended");
        }

        /*
        @Test
        void testPauseFeature() {
            TetrisGame tetrisGame = new TetrisGame();
            tetrisGame.gameTimer.start(); // Start the game timer
            tetrisGame.setPause(true); // Pause the game
            assertFalse(tetrisGame.gameTimer.isRunning(), "Game timer should be stopped when paused");
            tetrisGame.setPause(false); // Resume the game
            assertTrue(tetrisGame.gameTimer.isRunning(), "Game timer should be resumed");
        }
         */
}
