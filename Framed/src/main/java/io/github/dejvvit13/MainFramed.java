package io.github.dejvvit13;

import io.github.dejvvit13.game.Framed;

import javax.swing.*;
import java.awt.*;

public class MainFramed {
    public static void main(String[] args) {
        crossPlatformLookAndFeel();
        EventQueue.invokeLater(Framed::new);
    }

    private static void crossPlatformLookAndFeel() {
        try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch (Exception ignored) {
        }
    }
}
