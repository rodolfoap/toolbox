package org.rap.prgtests.twentyone;

import java.awt.*;
import java.awt.geom.*;

public class Day_12_DrawCircle extends javax.swing.JApplet {
    int radius, x, y;
    Color color;

    public void init() {
        String inRadius = getParameter("radius");
        String inX = getParameter("x");
        String inY = getParameter("y");
        String inColor = getParameter("color");
        if (inRadius == null)
            radius = 100;
        if (inX == null)
            x = 110;
        if (inY == null)
            y = 110;
        if (inColor == null)
            color = Color.blue;
        try {
            radius = Integer.parseInt(inRadius);
            x = Integer.parseInt(inX);
            y = Integer.parseInt(inY);
            color = Color.decode(inColor);
        } catch (NumberFormatException e) {
            showStatus("Parameter error" + e.getMessage());
        }
    }

    public void paint(Graphics screen) {
        Graphics2D screen2D = (Graphics2D)screen;
        screen2D.setColor(Color.white);
        screen2D.fillRect(0, 0, getSize().width, getSize().height);
        screen2D.setColor(color);
        Ellipse2D.Float circle = new Ellipse2D.Float(x, y, radius, radius);
        screen2D.fill(circle);
    }
}