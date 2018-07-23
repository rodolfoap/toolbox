package org.rap.prgtests.twentyone;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Day_13_Checkers extends JFrame implements ActionListener {
    CheckersPanel checkers = new CheckersPanel();
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");

    public Day_13_Checkers() {
        super("Checkers");
        setSize(210, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        BorderLayout border = new BorderLayout();
        pane.setLayout(border);
        pane.add(checkers, "Center");
        
        JPanel buttonPanel = new JPanel();
        startButton.addActionListener(this);
        buttonPanel.add(startButton);
        stopButton.addActionListener(this);
        stopButton.setEnabled(false);
        buttonPanel.add(stopButton);
        
        pane.add(buttonPanel, "South");
        setContentPane(pane);
        show();
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == startButton) {
            checkers.playAnimation();
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
        } else {
            checkers.stopAnimation();
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        }          
    }

    public static void main(String[] arguments) {
    	Day_13_Checkers ck = new Day_13_Checkers();
    }

}

class CheckersPanel extends JPanel implements Runnable {
    private Thread runner;
    int xPos = 5;
    int xMove = 4;

    void playAnimation() {
        if (runner == null); {
            runner = new Thread(this);
            runner.start();
        }
    }

    void stopAnimation() {
        if (runner != null); {
            runner = null;
        }
    }

    public void run() {
        Thread thisThread = Thread.currentThread();
        while (runner == thisThread) {
            xPos += xMove;
            if ((xPos > 105) | (xPos < 5))
                xMove *= -1;
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) { }
        }
   }

   public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D)comp;
        comp2D.setColor(Color.black);
        comp2D.fillRect(0, 0, 100, 100);
        comp2D.setColor(Color.white);
        comp2D.fillRect(100, 0, 100, 100);
        comp2D.setColor(Color.red);
       comp2D.fillOval(xPos, 5, 90, 90);
    }
}
