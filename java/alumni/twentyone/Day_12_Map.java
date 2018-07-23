package org.rap.prgtests.twentyone;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Day_12_Map extends JFrame {
    public Day_12_Map() {
        super("Map");
        setSize(350, 350);
        Day_12_ExitWindow exit = new Day_12_ExitWindow();
        MapPane map = new MapPane();
        getContentPane().add(map);
        addWindowListener(exit);
    }

    public static void main(String[] arguments) {
    	Day_12_Map frame = new Day_12_Map();
        frame.show();
    }

}

class MapPane extends JPanel {
    public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D)comp;
        comp2D.drawString("Florida", 185, 75);
        comp2D.drawLine(185, 80, 222, 80);
        comp2D.drawRect(2, 2, 335, 320);
        comp2D.drawRoundRect(182, 61, 43, 24, 10, 8);
        int x[] = { 10, 234, 253, 261, 333, 326, 295, 259, 205, 211,
            195, 191, 120, 94, 81, 12, 10 };
        int y[] = { 12, 15, 25, 71, 209, 278, 310, 274, 188, 171, 174,
            118, 56, 68, 49, 37, 12 };
        int pts = x.length;
        Polygon poly = new Polygon(x, y, pts);
        comp2D.drawPolygon(poly);
        comp2D.fillOval(235,140,15,15);
        comp2D.fillOval(225,130,15,15);
        comp2D.fillOval(245,130,15,15);
        for (int ax = 50; ax < 150; ax += 10)
            for (int ay = 120; ay < 320 ; ay += 10)
                comp2D.drawArc(ax, ay, 10, 10, 0, -180);
    }
}

//class ExitWindow extends WindowAdapter {
//    public void windowClosing(WindowEvent e) {
//        System.exit(0);
//    }
//}

