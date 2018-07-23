package org.rap.prgtests.twentyone;

import javax.swing.JFrame;

public class Day_12_SimpleFrame extends JFrame {
    public Day_12_SimpleFrame() {
        super("Frame Title");
        setSize(300, 100);
}

    public static void main(String[] arguments) {
    	Day_12_SimpleFrame sf = new Day_12_SimpleFrame();
        sf.show();
    }

}
