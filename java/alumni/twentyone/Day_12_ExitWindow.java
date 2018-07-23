package org.rap.prgtests.twentyone;

import java.awt.event.*;

public class Day_12_ExitWindow extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
