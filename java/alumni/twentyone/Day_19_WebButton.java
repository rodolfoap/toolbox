package org.rap.prgtests.twentyone;

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Day_19_WebButton extends JButton {
    String address;

    Day_19_WebButton(String iLabel, String iAddress) {
        super(iLabel);
        address = iAddress;
    }
}
