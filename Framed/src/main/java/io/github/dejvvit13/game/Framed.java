package io.github.dejvvit13.game;

import io.github.dejvvit13.game.buttons.LightButton;
import io.github.dejvvit13.game.labels.TitleLabel;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.Random;

public class Framed extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final int GRID_SIZE = 3;
    private final LightButton[][] buttons = new LightButton[GRID_SIZE][GRID_SIZE];
    Random random = new Random();

    public Framed() {
        initGUI();
        setGameProperties();
        newGame();
        pack();
    }

    private void newGame() {
        buttons[1][1].toggle();
        for (int i = 0; i < random.nextInt(10) + 10; i++) {
            toggleLights(buttons[random.nextInt(GRID_SIZE)][random.nextInt(GRID_SIZE)]);
        }
    }

    private void initGUI() {
        createTitleLabel();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        createCenterPanel();
    }

    private void createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        createButtons(centerPanel);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void createButtons(JPanel centerPanel) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                LightButton lightButton = new LightButton(row, col);
                addButtonActionListener(lightButton);
                buttons[row][col] = lightButton;
                centerPanel.add(lightButton);
            }
        }
    }

    private void addButtonActionListener(LightButton lightButton) {
        lightButton.addActionListener(e -> toggleLights(lightButton));
    }

    private void checkAndOverGame() {
        if (checkIfBoardIsFramed()) {
            String message = "Congratulations! You won! Do you want to play again?";
            int option = JOptionPane.showConfirmDialog(this, message, "Play again?", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                newGame();
            } else {
                System.exit(0);
            }
        }
    }

    private boolean checkIfBoardIsFramed() {
        return buttons[0][0].isLit()
                && buttons[0][1].isLit()
                && buttons[0][2].isLit()
                && buttons[1][0].isLit()
                && !buttons[1][1].isLit()
                && buttons[1][2].isLit()
                && buttons[2][0].isLit()
                && buttons[2][1].isLit()
                && buttons[2][2].isLit();
    }

    private void toggleLights(LightButton lightButton) {
        int row = lightButton.getRow();
        int col = lightButton.getCol();
        cornerLightLogic(row, col);
        middleLightLogic(row, col);
        checkAndOverGame();
    }


    private void cornerLightLogic(int row, int col) {
        if (row == 0 && col == 0) {
            buttons[row][col+1].toggle();
            buttons[row+1][col].toggle();
            buttons[row+1][col+1].toggle();
        }
        if (row == 0 && col == 2) {
            buttons[row][col-1].toggle();
            buttons[row+1][col].toggle();
            buttons[row+1][col-1].toggle();
        }
        if (row == 2 && col == 0) {
            buttons[row][col+1].toggle();
            buttons[row-1][col].toggle();
            buttons[row-1][col+1].toggle();
        }
        if (row == 2 && col == 2) {
            buttons[row][col-1].toggle();
            buttons[row-1][col].toggle();
            buttons[row-1][col-1].toggle();
        }
    }

    private void middleLightLogic(int row, int col) {
        if (row == 0 && col == 1) {
            buttons[row][col - 1].toggle();
            buttons[row][col + 1].toggle();
        }
        if (row == 2 && col == 1) {
            buttons[row][col - 1].toggle();
            buttons[row][col + 1].toggle();
        }
        if (row == 1 && col == 0) {
            buttons[row - 1][col].toggle();
            buttons[row + 1][col].toggle();
        }
        if (row == 1 && col == 2) {
            buttons[row - 1][col].toggle();
            buttons[row + 1][col].toggle();
        }
        if (row == 1 && col == 1) {
            buttons[row - 1][col].toggle();
            buttons[row + 1][col].toggle();
            buttons[row][col - 1].toggle();
            buttons[row][col + 1].toggle();
        }

    }

    private void createTitleLabel() {
        TitleLabel titleLabel = new TitleLabel("Framed");
        add(titleLabel, BorderLayout.PAGE_START);
    }

    private void setGameProperties() {
        setTitle("Framed");
        setResizable(false);
    }

}
