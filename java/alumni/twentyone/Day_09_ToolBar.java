package org.rap.prgtests.twentyone;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class Day_09_ToolBar extends JFrame {

    public Day_09_ToolBar() {
        super("ToolBar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image1 = new ImageIcon("Day_09_button1.gif");
        JButton button1 = new JButton(image1);
        ImageIcon image2 = new ImageIcon("Day_09_button2.gif");
        JButton button2 = new JButton(image2);
        ImageIcon image3 = new ImageIcon("Day_09_button3.gif");
        JButton button3 = new JButton(image3);
        JToolBar bar = new JToolBar();
        bar.add(button1);
        bar.add(button2);
        bar.add(button3);
        JTextArea edit = new JTextArea(8,40);
        JScrollPane scroll = new JScrollPane(edit);
        JPanel pane = new JPanel();
        BorderLayout bord = new BorderLayout();
        pane.setLayout(bord);
        pane.add("North", bar);
        pane.add("Center", scroll);

        setContentPane(pane);
    }

    public static void main(String[] arguments) {
    	Day_09_ToolBar frame = new Day_09_ToolBar();
        frame.pack();
        frame.setVisible(true);
    }
}
