package edu.gonzaga;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameOverScreen extends JFrame {
    private JLabel gameOverLabel;
    private JLabel playerNameLabel; // Player name label
    private JLabel scoreLabel; // Score label
    private JLabel playerNameValueLabel; // Label for player name value
    private JLabel scoreValueLabel; // Label for score value
    protected BufferedImage gameOverImage;

    public GameOverScreen() {
        setTitle("Game Over");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create and add components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Game Over Image Section
        gameOverLabel = new JLabel();
        gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
        try {
            gameOverImage = ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/GameOver.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image smallerImage = gameOverImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon((smallerImage));
        gameOverLabel.setIcon(icon);
        mainPanel.add(gameOverLabel, BorderLayout.NORTH);

        // Create new player
        Player testPlayer = new Player();
        testPlayer.setScore(1000);
        testPlayer.setName("John");

        // Player Name Section
        JPanel playerNamePanel = new JPanel();
        playerNameLabel = new JLabel("Player Name: ");
        playerNameValueLabel = new JLabel(testPlayer.getName());
        playerNameLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        playerNameValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font
        playerNamePanel.add(playerNameLabel);
        playerNamePanel.add(playerNameValueLabel);
        mainPanel.add(playerNamePanel, BorderLayout.CENTER);

        // Text Box Section for Player Score
        JPanel scorePanel = new JPanel();
        scoreLabel = new JLabel("Score: ");
        scoreValueLabel = new JLabel(Integer.toString(testPlayer.getScore()));
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        scoreValueLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font
        scorePanel.add(scoreLabel);
        scorePanel.add(scoreValueLabel);
        mainPanel.add(scorePanel, BorderLayout.AFTER_LAST_LINE);

        // Add main panel to frame
        add(mainPanel);

        setVisible(true);
    }

    // Temporary main to test game over screen
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameOverScreen());
    }
}
