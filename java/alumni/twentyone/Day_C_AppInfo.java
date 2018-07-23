package org.rap.prgtests.twentyone;

import java.awt.Graphics;

public class Day_C_AppInfo extends java.applet.Applet {
    String name, date;
    int version;
     
    public String getAppletInfo() {
        String response = "This applet demonstrates the "
            + "use of the Applet's Info feature.";
        return response;
    }
 
    public String[][] getParameterInfo() {
        String[] p1 = { "Name", "String", "Programmer's name" };
        String[] p2 = { "Date", "String", "Today's date" };
        String[] p3 = { "Version", "int", "Version number" };
        String[][] response = { p1, p2, p3 };
        return response;
    }
 
    public void init() {
        name = getParameter("Name");
        date = getParameter("Date");
        String versText = getParameter("Version");
        if (versText != null)
            version = Integer.parseInt(versText);
    }
 
    public void paint(Graphics screen) {
        screen.drawString("Name: " + name, 5, 50);
        screen.drawString("Date: " + date, 5, 100);
        screen.drawString("Version: " + version, 5, 150);
    }
}