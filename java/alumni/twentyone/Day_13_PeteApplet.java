package org.rap.prgtests.twentyone;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Day_13_PeteApplet extends JApplet {
	Day_13_PetePanel pete = new Day_13_PetePanel();

    public void init() {
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1, 1, 15, 15));
        pane.add(pete);
        setContentPane(pane);
    }
}