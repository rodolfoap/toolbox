package org.rap.prgtests.twentyone;

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Day_19_WebMenu extends JApplet implements ActionListener {
	Day_19_WebButton[] choices = new Day_19_WebButton[3];

    public void init() {
        choices[0] = new Day_19_WebButton("Obscure Store",
            "http://www.obscurestore.com/");
        choices[1] = new Day_19_WebButton("Need to Know",
            "http://www.ntk.net/");
        choices[2] = new Day_19_WebButton("Bleat",
            "http://www.lileks.com/bleats");
        FlowLayout flo = new FlowLayout();
        getContentPane().setLayout(flo);
        for (int i = 0; i < choices.length; i++) {
            choices[i].addActionListener(this);
            getContentPane().add(choices[i]);
        }
    }

    public void actionPerformed(ActionEvent evt) {
    	Day_19_WebButton clicked = (Day_19_WebButton)evt.getSource();
        try {
            URL load = new URL(clicked.address);
            getAppletContext().showDocument(load);
        } catch (MalformedURLException e) {
            showStatus("Bad URL:" + clicked.address);
        }
    }
}

//class WebButton extends JButton {
//    String address;
//
//    WebButton(String iLabel, String iAddress) {
//        super(iLabel);
//        address = iAddress;
//    }
//}





