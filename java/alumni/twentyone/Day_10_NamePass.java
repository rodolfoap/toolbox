package org.rap.prgtests.twentyone;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Day_10_NamePass extends JFrame {

    void buildConstraints(GridBagConstraints gbc, int gx, int gy,
        int gw, int gh, int wx, int wy) {

        gbc.gridx = gx;
        gbc.gridy = gy;
        gbc.gridwidth = gw;
        gbc.gridheight = gh;
        gbc.weightx = wx;
        gbc.weighty = wy;
    }

    public Day_10_NamePass() {
        super("Username and Password");
        setSize(290, 110);
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel pane = new JPanel();
        pane.setLayout(gridbag);

        // Name label
        buildConstraints(constraints, 0, 0, 1, 1, 10, 40);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        JLabel label1 = new JLabel("Name:", JLabel.LEFT);
        gridbag.setConstraints(label1, constraints);
        pane.add(label1);

        // Name text field
        buildConstraints(constraints, 1, 0, 1, 1, 90, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        JTextField tfname = new JTextField();
        gridbag.setConstraints(tfname, constraints);
        pane.add(tfname);

        // password label
        buildConstraints(constraints, 0, 1, 1, 1, 0, 40);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        JLabel label2 = new JLabel("Password:", JLabel.LEFT);
        gridbag.setConstraints(label2, constraints);
        pane.add(label2);

        // password text field
        buildConstraints(constraints, 1, 1, 1, 1, 0, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        JPasswordField tfpass = new JPasswordField();
        tfpass.setEchoChar('*');
        gridbag.setConstraints(tfpass, constraints);
        pane.add(tfpass);

        // OK Button
        buildConstraints(constraints, 0, 2, 2, 1, 0, 20);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        JButton okb = new JButton("OK");
        gridbag.setConstraints(okb, constraints);
        pane.add(okb);

        // Content Pane
        setContentPane(pane);
    }

    public static void main(String[] arguments) {
    	Day_10_NamePass frame = new Day_10_NamePass();
    	Day_12_ExitWindow exit = new Day_12_ExitWindow();
        frame.addWindowListener(exit);
        frame.show();
    }
}

//class Day_10_NamePass extends WindowAdapter {
//    public void windowClosing(WindowEvent e) {
//        System.exit(0);
//    }
//}
