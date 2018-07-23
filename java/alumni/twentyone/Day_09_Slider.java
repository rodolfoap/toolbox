package org.rap.prgtests.twentyone;

import java.awt.event.*;
import javax.swing.*; 

public class Day_09_Slider extends JFrame {

    public Day_09_Slider() {
        super("Slider");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSlider pickNum = new JSlider(JSlider.HORIZONTAL, 0, 30, 5);
        pickNum.setMajorTickSpacing(10);
        pickNum.setMinorTickSpacing(1);
        pickNum.setPaintTicks(true);
        pickNum.setPaintLabels(true);
        JPanel pane = new JPanel();
        pane.add(pickNum);

        setContentPane(pane);
    }

    public static void main(String[] args) {
    	Day_09_Slider frame = new Day_09_Slider();
        frame.pack();
        frame.setVisible(true);
    }
}
