package org.rap.prgtests.twentyone;

import javax.swing.*;

public class Day_08_Expiration extends JFrame {
    JComboBox monthBox = new JComboBox();
    JComboBox yearBox = new JComboBox();
    
    public Day_08_Expiration() {
        super("Expiration Date");
        setSize(220, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        JLabel exp = new JLabel("Expiration Date:");
        pane.add(exp);
        for (int i = 1; i < 13; i++)
            monthBox.addItem("" + i);
        for (int i = 2000; i < 2010; i++)
            yearBox.addItem("" + i);
        pane.add(monthBox);
        pane.add(yearBox);
        setContentPane(pane);
        show();
    }

    public static void main(String[] arguments) {
    	Day_08_Expiration ct = new Day_08_Expiration();
    }
}


