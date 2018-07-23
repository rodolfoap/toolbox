package org.rap.prgtests.scripts.gtz;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Event;
import java.awt.Point;

public class Gtz13_Puntos_Puntos_applet extends java.applet.Applet {
    Point punto = new Point();
    public void init() {
        setBackground(Color.white);
    }

    public boolean mouseDown(Event evt, int px, int py) {
        punto.x=px;
        punto.y=py;
        repaint();
        return true;
    }

    /**************************************************
       sobreposición del método update: 
       
       repaint() llama a update(); update() llama a paint()
       
       update tiene la forma general:
       
       public void update(Graphics g) {
       	g.setColor(getBackground());
	      g.fillRect(0,0,size.width(),size.height());
       	g.setColor(getForeground());
	      paint(g);
       }
    ***************************************************/
    
    public void update(Graphics g) { 
        paint(g);
    }
    
    public void paint(Graphics g) {
        g.fillOval(punto.x - 5, punto.y - 5, 10, 10);
    }
}
