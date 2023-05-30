package io.github.dejvvit13.game.labels;

import javax.swing.*;
import java.awt.*;

public class TitleLabel extends JLabel {

    private static final long serialVersionUID = 1L;

    public TitleLabel(String text) {
        super(text);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setOpaque(true);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font(Font.SERIF, Font.BOLD, 32));
    }

}
