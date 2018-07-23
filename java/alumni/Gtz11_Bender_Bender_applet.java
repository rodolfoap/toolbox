package org.rap.prgtests.scripts.gtz;

import java.awt.Graphics;
import java.awt.Image;

public class Gtz11_Bender_Bender_applet extends java.applet.Applet {
    Image robot;

    public void init() {
        robot = getImage(getCodeBase(), "pics/bender.jpg");
    }

    public void paint(Graphics screen) {
        int iWidth = robot.getWidth(this);   //ancho de la imagen
        int iHeight = robot.getHeight(this); //alto  de la imagen
        int xPos = 10;
        
        // 25%
        screen.drawImage(robot, xPos, 10, iWidth / 4, iHeight / 4, this);

        // 100%
        xPos += (iWidth / 4) + 10;
        screen.drawImage(robot, xPos, 10, this);
    }
}
