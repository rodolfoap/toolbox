package org.rap.prgtests.twentyone;

import javax.swing.JWindow;

public class Day_08_SimpleWindow extends JWindow {
    public Day_08_SimpleWindow() {
        super();
        setBounds(250, 225, 300, 150);
}

    public static void main(String[] arguments) {
    	Day_08_SimpleWindow sw = new Day_08_SimpleWindow();
        sw.setVisible(true);
        for (int i = 0; i < 10000; i++)
            System.out.print(i + " ");
        sw.setVisible(false);
        System.exit(0);
    }

}

