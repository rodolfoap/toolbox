package org.rap.prgtests.twentyone;

import javax.swing.*;

public class Day_08_VCR extends JFrame {
    JButton play = new JButton("Play");
    JButton stopEject = new JButton("Stop/Eject");
    JButton rewind = new JButton("Rewind");
    JButton fastForward = new JButton("Fast Forward");
    JButton pause = new JButton("Pause");
    
    public Day_08_VCR() {
        super("VCR");
        setSize(540, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.add(play);
        pane.add(stopEject);
        pane.add(rewind);
        pane.add(fastForward);
        pane.add(pause);
        setContentPane(pane);
        setVisible(true);
}

    public static void main(String[] arguments) {
    	Day_08_VCR vcr = new Day_08_VCR();
    }
}

