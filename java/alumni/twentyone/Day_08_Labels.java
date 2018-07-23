package org.rap.prgtests.twentyone;

import java.awt.*;
import javax.swing.*;

public class Day_08_Labels extends JFrame {
    JLabel tinker = new JLabel("Tinker", SwingConstants.LEFT);
    JLabel evers = new JLabel("Evers", SwingConstants.CENTER);
    JLabel chance = new JLabel("Chance", SwingConstants.RIGHT);

    public Day_08_Labels() {
        super("Labels");
        setSize(190, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(3, 1));
        pane.add(tinker);
        pane.add(evers);
        pane.add(chance);
        setContentPane(pane);
}

    public static void main(String[] arguments) {
    	Day_08_Labels lb = new Day_08_Labels();
        lb.show();
    }
}

