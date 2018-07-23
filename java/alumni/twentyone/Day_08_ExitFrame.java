package org.rap.prgtests.twentyone;

import javax.swing.JFrame;

public class Day_08_ExitFrame extends JFrame {
    public Day_08_ExitFrame() {
        super("Frame Title");
        setSize(300, 100);
        ExitWindow exit = new ExitWindow();
        addWindowListener(exit);
        setVisible(true);
    }
 
    public static void main(String[] arguments) {
    	Day_08_ExitFrame sf = new Day_08_ExitFrame();
    }

}


