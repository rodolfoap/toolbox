package org.rap.prgtests.twentyone;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Day_13_Headlines extends JFrame {
    HeadlinePanel news = new HeadlinePanel();

    public Day_13_Headlines() {
        super("Headlines");
        setSize(420, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1, 1, 15, 15));
        pane.add(news);
        setContentPane(pane);
        show();
        news.scroll();
    }

    public static void main(String[] arguments) {
    	Day_13_Headlines head = new Day_13_Headlines();
    }
}

class HeadlinePanel extends JPanel {
    String[] headlines = { 
        "Grandmother of Eight Makes Hole in One",
        "Police Begin Campaign to Run Down Jaywalkers",
        "Dr. Ruth to Talk About Sex with Newspaper Editors",
        "Enraged Cow Injures Farmer with Axe"
    };
    int y = 76;

    void scroll() {
        while (true) {
            y = y - 1;
            if (y < -75)
                y = 76;
            repaint();
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) { }
        }
    }

    public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D)comp;
        Font type = new Font("monospaced", Font.BOLD, 14);
        comp2D.setFont(type);
        comp2D.setColor(getBackground());
        comp2D.fillRect(0, 0, getSize().width, getSize().height);
        comp2D.setColor(Color.black);
        for (int i = 0; i < headlines.length; i++)
            comp2D.drawString(headlines[i], 5, y + (20 * i));
    }

}
