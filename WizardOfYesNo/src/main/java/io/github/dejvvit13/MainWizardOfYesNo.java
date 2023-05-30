package io.github.dejvvit13;

import io.github.dejvvit13.game.WizardOfYesNo;

import javax.swing.*;
import java.awt.*;

public class MainWizardOfYesNo {

    public static void main(String[] args) {
        crossPlatformLookAndFeel();
        EventQueue.invokeLater(WizardOfYesNo::new);
    }

    private static void crossPlatformLookAndFeel() {
        try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch (Exception ignored) {}
    }

}
