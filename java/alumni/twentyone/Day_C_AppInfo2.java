package org.rap.prgtests.twentyone;

import java.awt.Graphics;

/** This class creates displays the values of three parameters:
  * Name, Date and Version.
  * @author <a href="http://www.naviseek.com/java21">Rogers Cadenhead</a>
  * @version 2.0
 */
public class Day_C_AppInfo2 extends java.applet.Applet {
    /**
      * @serial The programmer's name.
    */
    String name;
    /**
      * @serial The current date.
    */
    String date;
    /**
      * @serial The program's version number.
    */
    int version;
    
    /**
      * This method describes the applet for any browsing tool that
      * request information out the program.
      * @return A String describing the applet.
     */
    public String getAppletInfo() {
        String response = "This applet demonstrates the "
            + "use of the Applet's Info feature.";
        return response;
    }

    /**
      * This method describes the parameters that the applet can take
      * for any browsing tool that requests this information.
      * @return An array of String[] objects for each parameter.
     */
    public String[][] getParameterInfo() {
        String[] p1 = { "Name", "String", "Programmer's name" };
        String[] p2 = { "Date", "String", "Today's date" };
        String[] p3 = { "Version", "int", "Version number" };
        String[][] response = { p1, p2, p3 };
        return response;
    }

    /**
      * This method is called when the applet is first initialized.
     */
    public void init() {
        name = getParameter("Name");
        date = getParameter("Date");
        String versText = getParameter("Version");
        if (versText != null)
            version = Integer.parseInt(versText);
    }

    /**
      * This method is called when the applet's display window is
      * being repainted.
     */
    public void paint(Graphics screen) {
        screen.drawString("Name: " + name, 5, 50);
        screen.drawString("Date: " + date, 5, 100);
        screen.drawString("Version: " + version, 5, 150);
    }
}
