package edu.gonzaga;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameOverScreen extends JFrame {
    private JLabel gameOverLabel;
    private JTextField textField;
    private JLabel integerLabel;
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

        //create new player
        Player testPlayer = new Player();
        testPlayer.setScore(1000);
        textField = new JTextField(20);
        textField.setText(Integer.toString(testPlayer.getScore()));

        // Text Box Section
        JPanel textBoxPanel = new JPanel();
        textBoxPanel.add(textField);
        mainPanel.add(textBoxPanel, BorderLayout.CENTER);

        // Integer Display Section
        JPanel integerPanel = new JPanel();
        integerLabel = new JLabel("0");
        integerPanel.add(integerLabel);
        mainPanel.add(integerPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);

        setVisible(true);
    }

    //Temporary main to test game over screen
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameOverScreen());
    }
}
