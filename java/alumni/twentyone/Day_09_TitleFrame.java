package org.rap.prgtests.twentyone;

import java.awt.event.*;
import javax.swing.*;

public class Day_09_TitleFrame extends JFrame {
    public Day_09_TitleFrame() {
        super("Title Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        String response = JOptionPane.showInputDialog(null,
            "Enter a Title for the Frame:");
        setTitle(response);
    }

    public static void main(String[] arguments) {
        JFrame frame = new Day_09_TitleFrame();
    }
}
