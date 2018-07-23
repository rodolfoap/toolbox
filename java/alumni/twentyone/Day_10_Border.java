package org.rap.prgtests.twentyone;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Day_10_Border extends JFrame {
    JButton north = new JButton("North");
    JButton south = new JButton("South");
    JButton east = new JButton("East");
    JButton west = new JButton("West");
    JButton center = new JButton("Center");

    Day_10_Border() {
        super("Border");
        setSize(240, 280);
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add("North", north);
        pane.add("South", south);
        pane.add("East", east);
        pane.add("West", west);
        pane.add("Center", center);
        setContentPane(pane);
    }

    public static void main(String[] arguments) {
        JFrame frame = new Day_10_Border();
        ExitWindow exit = new ExitWindow();
        frame.addWindowListener(exit);
        frame.show();
    }
}

