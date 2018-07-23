package org.rap.prgtests.twentyone;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Day_10_Alphabet extends JFrame {
    JButton a = new JButton("Alibi");
    JButton b = new JButton("Burglar");
    JButton c = new JButton("Corpse");
    JButton d = new JButton("Deadbeat");
    JButton e = new JButton("Evidence");
    JButton f = new JButton("Fugitive");

    Day_10_Alphabet() {
        super("Alphabet");
        setSize(360, 120);
        JPanel pane = new JPanel();
        FlowLayout lm = new FlowLayout(FlowLayout.LEFT);
        pane.setLayout(lm);
        pane.add(a);
        pane.add(b);
        pane.add(c);
        pane.add(d);
        pane.add(e);
        pane.add(f);
        setContentPane(pane);
    }

    public static void main(String[] arguments) {
        JFrame frame = new Day_10_Alphabet();
        ExitWindow exit = new ExitWindow();
        frame.addWindowListener(exit);
        frame.show();
    }
}

class ExitWindow extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

