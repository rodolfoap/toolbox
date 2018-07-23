package org.rap.prgtests.twentyone;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Day_09_Info extends JFrame {
    private JLabel titleLabel = new JLabel("Title: ",
        SwingConstants.RIGHT);
    private JTextField title;
    private JLabel addressLabel = new JLabel("Address: ",
        SwingConstants.RIGHT);
    private JTextField address;
    private JLabel typeLabel = new JLabel("Type: ",
        SwingConstants.RIGHT);
    private JTextField type;

    public Day_09_Info() {
        super("Site Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Site name
        String response1 = JOptionPane.showInputDialog(null,
            "Enter the site title:");
        title = new JTextField(response1, 20);

        // Site address
        String response2 = JOptionPane.showInputDialog(null,
            "Enter the site address:");
        address = new JTextField(response2, 20);

        // Site type
        String[] choices = { "Personal", "Commercial", "Unknown" };
        int response3 = JOptionPane.showOptionDialog(null,
            "What type of site is it?",
            "Site Type",
            0,
            JOptionPane.QUESTION_MESSAGE,
            null,
            choices,
            choices[0]);
        type = new JTextField(choices[response3], 20);

        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(3, 2));
        pane.add(titleLabel);
        pane.add(title);
        pane.add(addressLabel);
        pane.add(address);
        pane.add(typeLabel);
        pane.add(type);

        setContentPane(pane);
    }

    public static void main(String[] arguments) {
        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Couldn't use the system "
                + "look and feel: " + e);
        }

        JFrame frame = new Day_09_Info();
        frame.pack();
        frame.setVisible(true);
    }
}
