package io.github.dejvvit13.game;

import io.github.dejvvit13.game.labels.TitleLabel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class GuessMyColorGame extends JFrame {

    private static final long serialVersionUID = 1L;
    Random random = new Random();
    private final String GAME_NAME = "Guess My Color";
    private final JPanel samplePanel = new JPanel();
    private final JPanel targetPanel = new JPanel();
    private final Dimension colorPanelsSize = new Dimension(200, 200);

    private int targetRed = 0;
    private int targetGreen = 0;
    private int targetBlue = 0;
    private int currentRed = 0;
    private int currentGreen = 0;
    private int currentBlue = 0;


    public GuessMyColorGame() {
        initGUI();
        pack();
    }

    public void initGUI() {
        setWindowProperties();
        createPanels();
    }

    private void setWindowProperties() {
        setTitle(GAME_NAME);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void createPanels() {
        createTitleLabel();
        createCenterPanel();
        createButtonPanel();
    }

    private void createTitleLabel() {
        add(new TitleLabel(GAME_NAME), BorderLayout.PAGE_START);
    }

    private void createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        add(centerPanel, BorderLayout.CENTER);
        formatAndAddColorPanelsToCenterPanel(centerPanel);
    }

    private void formatAndAddColorPanelsToCenterPanel(JPanel centerPanel) {
        formatSamplePanel();
        formatTargetPanel();
        centerPanel.add(samplePanel, BorderLayout.LINE_START);
        centerPanel.add(targetPanel, BorderLayout.LINE_END);
    }

    private void formatSamplePanel() {
        samplePanel.setBackground(Color.BLACK);
        samplePanel.setPreferredSize(colorPanelsSize);
    }

    private void formatTargetPanel() {
        targetPanel.setBackground(generateTargetColor());
        targetPanel.setPreferredSize(colorPanelsSize);
    }

    private Color generateTargetColor() {
        this.targetRed = getRandRgbValue();
        this.targetGreen = getRandRgbValue();
        this.targetBlue = getRandRgbValue();
        return new Color(targetRed, targetGreen, targetBlue);
    }

    private int getRandRgbValue() {
        return random.nextInt(0, 18) * 15;
    }

    private void createButtonPanel() {
        JPanel buttonPanel = getButtonPanel();
        createButtons(buttonPanel);
        add(buttonPanel, BorderLayout.PAGE_END);
    }

    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        return buttonPanel;
    }

    private void createButtons(JPanel buttonPanel) {
        JButton[] buttons = {moreRedButton(), lessRedButton(), moreGreenButton(), lessGreenButton(), moreBlueButton(), lessBlueButton()};
        Arrays.stream(buttons).forEach(this::formatButton);
        Arrays.stream(buttons).forEach(buttonPanel::add);
    }

    private JButton moreRedButton() {
        JButton moreRedButton = new JButton("+");
        moreRedButton.setBackground(Color.red);
        moreRedButton.addActionListener(e -> increaseRed());
        return moreRedButton;
    }

    private JButton lessRedButton() {
        JButton lessRedButton = new JButton("-");
        lessRedButton.setBackground(Color.red);
        lessRedButton.addActionListener(e -> decreaseRed());
        return lessRedButton;
    }

    private JButton moreGreenButton() {
        JButton moreGreenButton = new JButton("+");
        moreGreenButton.setBackground(Color.green);
        moreGreenButton.addActionListener(e -> increaseGreen());
        return moreGreenButton;
    }

    private JButton lessGreenButton() {
        JButton lessGreenButton = new JButton("-");
        lessGreenButton.setBackground(Color.green);
        lessGreenButton.addActionListener(e -> decreaseGreen());
        return lessGreenButton;
    }

    private JButton moreBlueButton() {
        JButton moreBlueButton = new JButton("+");
        moreBlueButton.setBackground(Color.blue);
        moreBlueButton.addActionListener(e -> increaseBlue());
        return moreBlueButton;
    }

    private JButton lessBlueButton() {
        JButton lessBlueButton = new JButton("-");
        lessBlueButton.setBackground(Color.blue);
        lessBlueButton.addActionListener(e -> decreaseBlue());
        return lessBlueButton;
    }

    private void formatButton(JButton button) {
        button.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
    }

    private void updateSamplePanelColor() {
        samplePanel.setBackground(new Color(currentRed, currentGreen, currentBlue));
        if (isTargetColor()) {
            JOptionPane.showMessageDialog(this, "You win!");
        }
    }

    private boolean isTargetColor() {
        return currentRed == targetRed && currentGreen == targetGreen && currentBlue == targetBlue;
    }

    private void increaseRed() {
        if (currentRed <= 240) {
            currentRed += 15;
            updateSamplePanelColor();
        }
    }
    private void decreaseRed() {
        if (currentRed >= 15) {
            currentRed -= 15;
            updateSamplePanelColor();
        }
    }
    private void increaseGreen() {
        if (currentGreen <= 240) {
            currentGreen += 15;
            updateSamplePanelColor();
        }
    }
    private void decreaseGreen() {
        if (currentGreen >= 15) {
            currentGreen -= 15;
            updateSamplePanelColor();
        }
    }
    private void increaseBlue() {
        if (currentBlue <= 240) {
            currentBlue += 15;
            updateSamplePanelColor();
        }
    }
    private void decreaseBlue() {
        if (currentBlue >= 15) {
            currentBlue -= 15;
            updateSamplePanelColor();
        }
    }


}
