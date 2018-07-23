package org.rap.prgtests.twentyone;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Day_13_Pete extends JFrame {
	Day_13_PetePanel pete = new Day_13_PetePanel();

    public Day_13_Pete() {
        super("Pixel Pete");
        setSize(452, 146);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1, 1, 15, 15));
        pane.add(pete);
        setContentPane(pane);
        show();
    }

    public static void main(String[] arguments) {
    	Day_13_Pete penguin = new Day_13_Pete();
    }
}

