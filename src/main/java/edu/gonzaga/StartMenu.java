package edu.gonzaga;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartMenu extends JPanel {
    protected BufferedImage tetrisLogo;
    protected BufferedImage backgroundImage;
    protected ImageIcon startIcon;
    protected JButton startButton;
    protected JButton settingButton;
    protected JLabel nameLabel;
    protected String info = "Tetris Game by [Team Tetris: Jack Ou, Nick DeYoung, Mingze Zhang]";
    TetrisGame game;

    public StartMenu(TetrisGame game) {
        this.game = game;
        try {
            tetrisLogo = ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/TetrisLogo.png"));
            backgroundImage = ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/backgroundImg.png"));
            startIcon = new ImageIcon(ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/StartButton.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(null);
        setSize(500, 700);
        setVisible(true);
        startButton = new JButton("Start Game");
        startButton.setSize(100, 50);
        startButton.setLocation(200, 400);
        startButton.setVisible(true);

        settingButton = new JButton("Settings");
        settingButton.setSize(startButton.getSize());
        settingButton.setLocation(200, 450);
        settingButton.setVisible(true);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    game.startGame();
                    setVisible(false);
                } catch (IOException | InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Adding difficulty selection as radio buttons in a popup menu
        JPopupMenu difficultyMenu = new JPopupMenu();
        JCheckBoxMenuItem easy = new JCheckBoxMenuItem("Easy");
        JCheckBoxMenuItem medium = new JCheckBoxMenuItem("Medium");
        JCheckBoxMenuItem hard = new JCheckBoxMenuItem("Hard");
        medium.setSelected(true); // Set Medium as default

        // Group the radio buttons to enforce single selection
        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(easy);
        difficultyGroup.add(medium);
        difficultyGroup.add(hard);

        difficultyMenu.add(easy);
        difficultyMenu.add(medium);
        difficultyMenu.add(hard);

        // Add listeners to menu items
        easy.addActionListener(e -> setDifficulty("Easy"));
        medium.addActionListener(e -> setDifficulty("Medium"));
        hard.addActionListener(e -> setDifficulty("Hard"));

        startButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // Show the menu above the button
                difficultyMenu.show(startButton, 0, -difficultyMenu.getPreferredSize().height);
            }

            public void mouseExited(MouseEvent e) {
                // Delay hiding the menu to check if the mouse is over the menu
                SwingUtilities.invokeLater(() -> {
                    if (!difficultyMenu.isShowing() || !difficultyMenu.getBounds().contains(e.getPoint())) {
                        difficultyMenu.setVisible(false);
                    }
                });
            }
        });

        difficultyMenu.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {}

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                difficultyMenu.setVisible(false);
            }
        });

        add(startButton);
        add(settingButton);
        nameLabel = new JLabel();
        nameLabel.setLocation(30, 650);
        nameLabel.setSize(600, 20);
    }

    public StartMenu() {
        this(new TetrisGame());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, 500, 700, null);
        g.drawImage(tetrisLogo, 50, 0, 400, 300, null);
        g.setColor(new Color(255, 255, 255));
        g.drawBytes(info.getBytes(), 0, info.getBytes().length, 30, 650);
    }

    private void setDifficulty(String difficulty) {
        System.out.println("Difficulty set to: " + difficulty);
        if(difficulty.compareTo("Easy")==0) {
            game.setRunTimerDelay(200);
        }
        else if(difficulty.compareTo("Medium")==0) {
            game.setRunTimerDelay(120);
        }
        else if(difficulty.compareTo("Hard")==0) {
            game.setRunTimerDelay(70);
        }
    }
}
