package io.github.dejvvit13.game.buttons;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LightButton extends JButton {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int MAX_SIZE = 150;
    private int row = 0;
    private int col = 0;

    public LightButton(int row, int col) {
        this.row = row;
        this.col = col;
        formatButton();
        setPreferredSize(new Dimension(MAX_SIZE, MAX_SIZE));
    }

    private void formatButton() {
        setBackground(Color.BLACK);
    }

    public void toggle() {
        if (isLit()) {
            turnOff();
        } else {
            turnOn();
        }
    }

    private void turnOn() {
        setBackground(Color.RED);
    }

    private void turnOff() {
        setBackground(Color.BLACK);
    }

    public boolean isLit() {
        return getBackground().equals(Color.RED);
    }

}
