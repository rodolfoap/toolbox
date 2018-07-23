package org.rap.prgtests.scripts.gtz;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Event;
import java.awt.Point;

public class Gtz13_Puntos_Lineas_applet extends java.applet.Applet {
    final int MAXLINES = 10;
    Point starts[] = new Point[MAXLINES]; 	// puntos de inicio
    Point ends[]   = new Point[MAXLINES];    // puntos de final 
    Point anchor;    	// inicio de linea
    Point currentpoint; // final de linea
    int currline = 0; 	// numero de lineas

    public void init() {
        setBackground(Color.white);
    }

    public boolean mouseDown(Event evt, int x, int y) {
        if (currline < MAXLINES) {
            anchor = new Point(x,y);
            return true;
        }
        else  {
            System.out.println("Demasiadas líneas...");
            return false;
        }
    }

    public boolean mouseUp(Event evt, int x, int y) {
        if (currline < MAXLINES) {
             addline(x,y);
             return true;
        }
        else return false;
    }

    public boolean mouseDrag(Event evt, int x, int y) {
        if (currline < MAXLINES) {
            currentpoint = new Point(x,y);
            repaint();
            return true;
        }
        else return false;
    }

    void addline(int x,int y) {
        starts[currline] = anchor;
        ends[currline] = new Point(x,y);
        currline++;
        currentpoint = null;
        anchor = null;
        repaint();
    }

    public void paint(Graphics g) {
        // Dibujar lineas existentes
        for (int i = 0; i < currline; i++) {
            g.drawLine(starts[i].x, starts[i].y,
                 ends[i].x, ends[i].y);
        }

        // Dibujar linea actual
        g.setColor(Color.blue);
        if (currentpoint != null)
            g.drawLine(anchor.x,anchor.y, currentpoint.x,currentpoint.y);
    }
}
