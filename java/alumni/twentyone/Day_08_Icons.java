package org.rap.prgtests.twentyone;

import javax.swing.*;

public class Day_08_Icons extends JFrame {
    JButton[] buttons = new JButton[24];

    public Day_08_Icons() {
        super("Icons");
        setSize(335, 318);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        ImageIcon icon = new ImageIcon("Day_08_3dman.gif");
        for (int i = 0; i < 24; i++) {
            buttons[i] = new JButton(icon);
            pane.add(buttons[i]);
        }
        setContentPane(pane);
        show();
    }

    public static void main(String[] arguments) {
    	Day_08_Icons ike = new Day_08_Icons();
    }
}

