package org.rap.prgtests.twentyone;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Day_11_ChangeTitle extends JFrame implements ActionListener {
    JButton b1 = new JButton("Rosencrantz");
    JButton b2 = new JButton("Guildenstern");

    public Day_11_ChangeTitle() {
        super("Title Bar");

        b1.addActionListener(this);
        b2.addActionListener(this);
        JPanel pane = new JPanel();
        pane.add(b1);
        pane.add(b2);

        setContentPane(pane);
    }

    public static void main(String[] arguments) {
        JFrame frame = new Day_11_ChangeTitle();

        ExitWindow exit = new ExitWindow();
        frame.addWindowListener(exit);

        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if (source == b1)
            setTitle("Rosencrantz");
        else if (source == b2)
            setTitle("Guildenstern");
        repaint();
    }
}

//class ExitWindow extends WindowAdapter {
//    public void windowClosing(WindowEvent e) {
//        System.exit(0);
//    }
//}
