package org.rap.prgtests.twentyone;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Day_11_WellAdjusted extends JFrame implements AdjustmentListener {
    JTextField value = new JTextField("50", 30);
    JScrollBar bar = new JScrollBar(SwingConstants.HORIZONTAL,
        50, 10, 0, 100);

    public Day_11_WellAdjusted() {
        super("Well Adjusted");
        setSize(350, 100);
        bar.addAdjustmentListener(this);
        value.setHorizontalAlignment(SwingConstants.CENTER);
        value.setEditable(false);
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add(value, "Center");
        pane.add(bar, "South");
        setContentPane(pane);
    }

    public static void main(String[] arguments) {
        JFrame frame = new Day_11_WellAdjusted();

        Day_12_ExitWindow exit = new Day_12_ExitWindow();
        frame.addWindowListener(exit);

        frame.show();
    }

    public void adjustmentValueChanged(AdjustmentEvent evt) {
        Object source = evt.getSource();
        if (source == bar) {
            int newValue = bar.getValue();
            value.setText("" + newValue);
        }
        repaint();
    }
}
