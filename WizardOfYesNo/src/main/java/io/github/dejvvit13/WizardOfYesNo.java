package io.github.dejvvit13;

import javax.swing.*;

public class WizardOfYesNo extends JFrame {
    public static void main(String[] args) {
        new WizardOfYesNo();
    }

    public WizardOfYesNo() {
        setWindowProperties();
    }

    private void setWindowProperties() {
        setSize(200, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
