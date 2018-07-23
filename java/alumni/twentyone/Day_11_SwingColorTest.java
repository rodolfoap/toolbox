package org.rap.prgtests.twentyone;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Day_11_SwingColorTest extends JFrame {
    SwingColorControls RGBcontrols, HSBcontrols;
    JPanel swatch;

    public Day_11_SwingColorTest() {
        super("Color Test");

        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1, 3, 5, 15));
        swatch = new JPanel();
        swatch.setBackground(Color.black);
        String[] rgbLabels = { "Red", "Green", "Blue" };
        RGBcontrols = new SwingColorControls(this, rgbLabels);
        String[] hsbLabels = { "Hue", "Saturation", "Brightness" };
        HSBcontrols = new SwingColorControls(this, hsbLabels);
        pane.add(swatch);
        pane.add(RGBcontrols);
        pane.add(HSBcontrols);

        setContentPane(pane);
    }

    public static void main(String[] arguments) {
        JFrame frame = new Day_11_SwingColorTest();

        ExitWindow exit = new ExitWindow();
        frame.addWindowListener(exit);

        frame.pack();
        frame.setVisible(true);
    }

    public Insets getInsets() {
        return new Insets(10, 10, 10, 10);
    }

    void update(SwingColorControls control) {
        Color c;
        // get string values from text fields, convert to ints
        int[] value = new int[3];
        for (int i = 0; i < 3; i++) {
            value[i] = Integer.parseInt(control.tfield[i].getText());
            if ((value[i] < 0) || (value[i] > 255)) {
                value[i] = 0;
                control.tfield[i].setText("" + value[i]);
            }
        }
        if (control == RGBcontrols) {
            // RGB has changed, update HSB
            c = new Color(value[0], value[1], value[2]);

            // convert RGB values to HSB values
            float[] HSB = Color.RGBtoHSB(value[0], value[1], value[2],
                (new float[3]));
            HSB[0] *= 360;
            HSB[1] *= 100;
            HSB[2] *= 100;

            // reset HSB fields
            for (int i = 0; i < 3; i++) {
                HSBcontrols.tfield[i].setText(String.valueOf((int)HSB[i]));
            }
        } else {
            // HSB has changed, update RGB
            c = Color.getHSBColor((float)value[0] / 360,
                (float)value[1] / 100, (float)value[2] / 100);

            // reset RGB fields
            RGBcontrols.tfield[0].setText(String.valueOf(c.getRed()));
            RGBcontrols.tfield[1].setText(String.valueOf(c.getGreen()));
            RGBcontrols.tfield[2].setText(String.valueOf(c.getBlue()));
        }

        // update swatch
        swatch.setBackground(c);
        swatch.repaint();
    }
}

class SwingColorControls extends JPanel
    implements ActionListener, FocusListener {

	Day_11_SwingColorTest frame;
    JTextField[] tfield = new JTextField[3];

    SwingColorControls(Day_11_SwingColorTest parent, String[] label) {

        frame = parent;
        setLayout(new GridLayout(3, 2, 10, 10));
        for (int i = 0; i < 3; i++) {
            tfield[i] = new JTextField("0");
            tfield[i].addFocusListener(this);
            tfield[i].addActionListener(this);
            add(new JLabel(label[i], JLabel.RIGHT));
            add(tfield[i]);
        }
    }

    public Insets getInsets() {
        return new Insets(10, 10, 0, 0);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() instanceof JTextField)
            frame.update(this);
    }

    public void focusLost(FocusEvent evt) {
        frame.update(this);
    }

    public void focusGained(FocusEvent evt) { }

}

//class ExitWindow extends WindowAdapter {
//    public void windowClosing(WindowEvent e) {
//        System.exit(0);
//    }
//}
