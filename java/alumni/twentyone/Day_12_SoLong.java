package org.rap.prgtests.twentyone;

import java.awt.*;

public class Day_12_SoLong extends javax.swing.JApplet {

    public void paint(Graphics screen) {
        Graphics screen2D = (Graphics2D)screen;
        Font f = new Font("monospaced", Font.BOLD, 18);
        FontMetrics fm = getFontMetrics(f);
        screen2D.setFont(f);
        String s = "So long, and thanks for all the fish.";
        int x = (getSize().width - fm.stringWidth(s)) / 2;
        int y = getSize().height / 2;
        screen2D.drawString(s, x, y);
    }
}
