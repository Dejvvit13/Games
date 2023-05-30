package io.github.dejvvit13;

import io.github.dejvvit13.game.GuessMyColorGame;

import javax.swing.*;
import java.awt.*;

public class MainGuessMyColor {
    public static void main(String[] args) {
        crossPlatformLookAndFeel();
        EventQueue.invokeLater(GuessMyColorGame::new);
    }

    private static void crossPlatformLookAndFeel() {
        try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch (Exception ignored) {
        }
    }
}