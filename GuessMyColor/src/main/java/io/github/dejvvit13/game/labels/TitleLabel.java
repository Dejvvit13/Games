package io.github.dejvvit13.game.labels;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class TitleLabel {

    JLabel label = new JLabel();

    public void initializeTitleLabel() {
        formatTitleLabel();
    }

    public void formatTitleLabel() {
        setTitleLabelFont();
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void setTitleLabelFont() {
        label.setFont(new Font(Font.SERIF, Font.BOLD, 32));
    }

}
