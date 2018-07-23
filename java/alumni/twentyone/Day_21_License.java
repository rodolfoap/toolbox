package org.rap.prgtests.twentyone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Day_21_License extends JFrame implements ActionListener {
    Vector plates;
    JTextField tag;

    Day_21_License() {
        super("License Plate Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(270, 115);
        Container pane = getContentPane();
        FlowLayout flo = new FlowLayout();
        pane.setLayout(flo);
        JLabel tagLabel = new JLabel("Enter a license plate number: ");
        tag = new JTextField(20);
        pane.add(tagLabel);
        pane.add(tag);
        JButton addTag = new JButton("OK");
        addTag.addActionListener(this);
        pane.add(addTag);
        setContentPane(pane);
        plates = new Vector(1000);
        show();
    }

    boolean addPlate(String tag) {
        if (plates.contains(tag))
             return false;
        else {
             plates.add(tag);
             return true;
        }
    }

    public void actionPerformed(ActionEvent evt) {
        boolean added = addPlate(tag.getText());
        if (!added)
            JOptionPane.showMessageDialog(this, 
                "That number is already taken.", 
                "Plate Unavailable", 
                JOptionPane.WARNING_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, 
                "License plate issued for " + tag.getText(), 
                "Plate Added", 
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] arguments) {
    	Day_21_License app = new Day_21_License();
    }
}