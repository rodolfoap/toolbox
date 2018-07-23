package org.rap.prgtests.twentyone;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Day_11_SelectItem extends JFrame implements ItemListener {
    BorderLayout bord = new BorderLayout();
    JTextField result = new JTextField(27);
    JComboBox pick = new JComboBox();

    public Day_11_SelectItem() {
        super("Select Item");

        pick.addItemListener(this);
        pick.addItem("Navigator");
        pick.addItem("Internet Explorer");
        pick.addItem("Opera");
        pick.setEditable(false);
        result.setHorizontalAlignment(SwingConstants.CENTER);
        result.setEditable(false);
        JPanel pane = new JPanel();
        pane.setLayout(bord);
        pane.add(result, "South");
        pane.add(pick, "Center");

        setContentPane(pane);
    }

    public static void main(String[] arguments) {
        JFrame frame = new Day_11_SelectItem();

        ExitWindow exit = new ExitWindow();
        frame.addWindowListener(exit);

        frame.pack();
        frame.setVisible(true);
    }

    public void itemStateChanged(ItemEvent evt) {
        Object source = evt.getSource();
        if (source == pick) {
            Object newPick = evt.getItem();
            result.setText(newPick.toString() + " is the selection.");
        }
        repaint();
    }
}
