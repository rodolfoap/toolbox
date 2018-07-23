package org.rap.prgtests.twentyone;

import javax.swing.*;

public class Day_08_Form extends javax.swing.JFrame {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JTextArea comments = new JTextArea(4, 15);

    public Day_08_Form() {
        super("Feedback Form");
        setSize(260, 160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pane = new JPanel();
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JLabel commentsLabel = new JLabel("Comments:");
        comments.setLineWrap(true);
        comments.setWrapStyleWord(true);
        pane.add(usernameLabel);
        pane.add(username);
        pane.add(passwordLabel);
        pane.add(password);
        pane.add(commentsLabel);
        pane.add(comments);
        setContentPane(pane);

        show();
    }

    public static void main(String[] arguments) {
    	Day_08_Form input = new Day_08_Form();
    }
}

