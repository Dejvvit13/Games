package io.github.dejvvit13.game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GuessMyColorGame extends JFrame {

    private static final long serialVersionUID = 1L;
    Random random = new Random();
    private final String GAME_NAME = "Guess My Color";
    private final JPanel samplePanel = new JPanel();
    private final JPanel targetPanel = new JPanel();
    private final Dimension colorPanelsSize = new Dimension(50,50);


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
        setSize(400,120);
    }
    public void createPanels(){
        createTitleLabel();
        createCenterPanel();
        createButtonPanel();
    }

    private void createTitleLabel() {
        JLabel titleLabel = new JLabel();
        titleLabel.setBackground(Color.BLACK);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setText(GAME_NAME);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 32));
        add(titleLabel, BorderLayout.PAGE_START);
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
        return new Color(getRandRgbValue(),getRandRgbValue(),getRandRgbValue());
    }
    private int getRandRgbValue(){
        return random.nextInt(0,18) * 15;
    }

    private void createButtonPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLACK);
        add(centerPanel, BorderLayout.PAGE_END);
    }


}
