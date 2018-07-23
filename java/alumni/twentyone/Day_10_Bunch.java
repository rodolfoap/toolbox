package org.rap.prgtests.twentyone;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Day_10_Bunch extends JFrame {
    JButton marcia = new JButton("Marcia");
    JButton carol = new JButton("Carol");
    JButton greg = new JButton("Greg");
    JButton jan = new JButton("Jan");
    JButton alice = new JButton("Alice");
    JButton peter = new JButton("Peter");
    JButton cindy = new JButton("Cindy");
    JButton mike = new JButton("Mike");
    JButton bobby = new JButton("Bobby");

    Day_10_Bunch() {
        super("Bunch");
        setSize(260, 260);
        JPanel pane = new JPanel();
        GridLayout family = new GridLayout(3, 3, 10, 10);
        pane.setLayout(family);
        pane.add(marcia);
        pane.add(carol);
        pane.add(greg);
        pane.add(jan);
        pane.add(alice);
        pane.add(peter);
        pane.add(cindy);
        pane.add(mike);
        pane.add(bobby);
        setContentPane(pane);
    }

    public static void main(String[] arguments) {
        JFrame frame = new Day_10_Bunch();
        ExitWindow exit = new ExitWindow();
        frame.addWindowListener(exit);
        frame.show();
    }
}

