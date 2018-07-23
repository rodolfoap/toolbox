package org.rap.prgtests.twentyone;

import javax.swing.JFrame;

public class Day_08_SimpleFrame extends JFrame {
    public Day_08_SimpleFrame() {
        super("Frame Title");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
 
    public static void main(String[] arguments) {
//    	Day_08_SimpleFrame sf = new Day_08_SimpleFrame();
    	new Day_08_SimpleFrame();
    }

}

