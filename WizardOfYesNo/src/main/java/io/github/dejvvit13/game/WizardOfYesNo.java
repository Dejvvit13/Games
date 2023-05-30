package io.github.dejvvit13.game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WizardOfYesNo extends JFrame {
    private static final long serialVersionUID = 1L;
    private final String WINDOW_TITLE = "Wizard of Yes/No";
    private final String[] answers = {
            "Yes.",
            "Go for it!",
            "Yes, definitely.",
            "For sure!",
            "I would say yes.",
            "Most likely yes.",
            "No.",
            "I wouldn't.",
            "In my opinion, no.",
            "Definitely not!",
            "Probably not.",
            "It is very doubtful."};
    Random rand = new Random();
    JLabel answerLabel = new JLabel();


    public WizardOfYesNo() {
        setWindowProperties();
        addAnswerLabel();
        drawAnswer();
        pack();
    }

    private void setWindowProperties() {
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle(WINDOW_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void addAnswerLabel() {
        formatAnswerLabel();
        add(answerLabel);
    }

    private void formatAnswerLabel() {
        setAnswerLabelFont();
        answerLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void setAnswerLabelFont() {
        Font font = new Font(Font.DIALOG, Font.BOLD, 32);
        answerLabel.setFont(font);
    }


    private void drawAnswer() {
        answerLabel.setText(answers[rand.nextInt(answers.length)]);
    }


}
