package org.rap.prgtests.twentyone;

import java.awt.*;
import javax.swing.*;

public class Day_13_Traffic extends JFrame {
    TrafficLight light = new TrafficLight();

    public Day_13_Traffic() {
        super("Traffic");
        setSize(100, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        BorderLayout bord = new BorderLayout();
        pane.setLayout(bord);
        pane.add(light, "Center");
        setContentPane(pane);
        show();
    }

    public static void main(String[] arguments) {
    	Day_13_Traffic tr = new Day_13_Traffic();
    }

}

class TrafficLight extends JPanel implements Runnable {
    private Thread runner;
    int counter = 0;

    TrafficLight() {
        if (runner == null); {
            runner = new Thread(this);
            runner.start();
        }
    }

    public void run() {
        Thread thisThread = Thread.currentThread();
        while (runner == thisThread) {
            counter++;
            if (counter > 2)
                counter = 0;
            repaint();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) { }
        }
   }

   public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D)comp;
        comp2D.setColor(Color.black);
        comp2D.fillRect(0, 0, 300, 300);
        if (counter == 0)
            comp2D.setColor(Color.green);
        else
            comp2D.setColor(Color.black);
        comp2D.fillOval(0, 0, 100, 100);
        if (counter == 1)
            comp2D.setColor(Color.yellow);
        else
            comp2D.setColor(Color.black);
        comp2D.fillOval(0, 100, 100, 100);
        if (counter == 2)
            comp2D.setColor(Color.red);
        else
            comp2D.setColor(Color.black);
        comp2D.fillOval(0, 200, 100, 100);
    }
}
