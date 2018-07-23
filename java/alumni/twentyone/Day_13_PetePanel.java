package org.rap.prgtests.twentyone;

import java.awt.*;
import javax.swing.*;
import java.util.*;

class Day_13_PetePanel extends JPanel implements Runnable {
    Thread runner;
    Image petePics[] = new Image[6];
    Image back;
    int current = 0;
    int x = -10;
    int y = 30;

    Day_13_PetePanel() {
        super();
        setBackground(Color.black);
        String peteSrc[] = { "right1.gif", "right2.gif",
            "right3.gif", "stop.gif", "blink.gif",
	        "wave.gif" };
        Toolkit kit = Toolkit.getDefaultToolkit();
        for (int i=0; i < petePics.length; i++) {
            petePics[i] = kit.getImage(peteSrc[i]);
        }
        back = kit.getImage("backdrop.gif");
        if (runner == null) {
            runner = new Thread(this);
            runner.start();
        }
    }

    public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D)comp;
        if (back != null)
            comp2D.drawImage(back, 0, 0, this);
        comp2D.setColor(Color.black);
        comp2D.fillRect(0, 30, 450, 30);
        if (petePics[current] != null)
            comp2D.drawImage(petePics[current], x, y, this);
    }

    public void run() {
        while (true) {
            walk(-10, 275);
            look();
            blink(3);
            wave(4);
            walk(x, getSize().width + 10);
            pause(1500);
        }
    }

    public void walk(int start, int end) {
        int showpic = 0;
        for (int i = start; i < end; i += 5) {
            x = i;
            // swap images
            current = showpic;
            repaint();
            pause(150);
            showpic++;
            if (showpic > 2)
                showpic = 0;
        }
    }

    public void blink(int numtimes) {
        for (int i = numtimes; i > 0; i--) {
            current = 4;
            repaint();
            pause(200);
            current = 3;
            repaint();
            pause(1000);
        }
    }

    public void wave(int numtimes) {
        for (int i = numtimes; i > 0; i--) {
            current = 3;
            repaint();
            pause(600);
            current = 5;
            repaint();
            pause(1100);
        }
    }

    public void look() {
        current = 3;
        repaint();
        pause(1000);
   }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) { }
    }
}
