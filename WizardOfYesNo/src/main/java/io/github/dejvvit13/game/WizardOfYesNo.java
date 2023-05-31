package io.github.dejvvit13.game;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.Random;

public class WizardOfYesNo extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final String WINDOW_TITLE = "Wizard of Yes/No";
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
        createDisclaimer();
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
        Font font = new Font(Font.DIALOG, Font.BOLD, 32);
        answerLabel.setFont(font);
        answerLabel.setOpaque(true);
        answerLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
    private void drawAnswer() {
        int answerIndex = rand.nextInt(answers.length);
        setProperBackgroundColorForAnswer(answerIndex);
        answerLabel.setText(answers[answerIndex]);
    }

    private void createDisclaimer() {
        final String disclaimer = """
                This program is for entertainment purposes only.
                It is not intended to be used as a decision-making tool.
                The author is not responsible for any consequences of using this program.
                """;
        JTextArea disclaimerArea = new JTextArea(disclaimer,3,30);
        disclaimerArea.setEditable(false);
        disclaimerArea.setLineWrap(true);
        disclaimerArea.setWrapStyleWord(true);
        createWithScroll(disclaimerArea);
    }

    private void createWithScroll(Component component){
        JScrollPane scrollPane = new JScrollPane(component);
        scrollPane.setPreferredSize(new Dimension(0, 50));
        add(scrollPane, BorderLayout.PAGE_END);
    }
    private void setProperBackgroundColorForAnswer(int answerIndex) {
        if (answerIndex < 6) {
            answerLabel.setBackground(Color.GREEN);
        } else {
            answerLabel.setBackground(Color.RED);
        }
    }


}
