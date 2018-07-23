package org.rap.prgtests.scripts.gtz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

public class Gtz12_Neko_Neko_applet extends java.applet.Applet implements Runnable {

    Image nekoPics[] = new Image[9];
    Image imagenActual;
    Thread hilo;
    int x;
    int y = 50;

    public void init() {
        String nekoGif[] = {"right1.gif", "right2.gif", "stop.gif", "yawn.gif", "scratch1.gif", "scratch2.gif","sleep1.gif", "sleep2.gif", "awake.gif"};
        for (int i=0; i < nekoPics.length; i++) 
            nekoPics[i] = getImage(getCodeBase(), "pics/" + nekoGif[i]);
    }

    public void start() {
        if (hilo == null) {
            hilo = new Thread(this);
            hilo.start();
        }
    }

    public void stop() {
        hilo = null;
    }

    public void run() {
        setBackground(Color.white);
        // Correr hasta el centro
        nekoCorrer(0, size().width / 2);
        // detener y pausar
        imagenActual = nekoPics[2];
        repaint();
        pausa(1000);
        // bostezar 
        imagenActual = nekoPics[3];
        repaint();
        pausa(1000);
        // rascarse 4 veces
        nekoRascar(4);
        // 5 ronquidos
        nekoDormir(5);
        // despertar y correr
        imagenActual = nekoPics[8];
        repaint();
        pausa(500);
        nekoCorrer(x, size().width + 10);
    }

    void nekoCorrer(int start, int end) {
        for (int i = start; i < end; i += 10) {
            x = i;
            // intercambiar imagenes
            if ( imagenActual == nekoPics[0])
                 imagenActual =  nekoPics[1];
            else imagenActual =  nekoPics[0];
            repaint();
            pausa(150);
        }
    }

    void nekoRascar(int numTimes) {
        for (int i = numTimes; i > 0; i--) {
            imagenActual = nekoPics[4];
            repaint();
            pausa(150);
            imagenActual = nekoPics[5];
            repaint();
            pausa(150);
        }
    }

    void nekoDormir(int numTimes) {
        for (int i = numTimes; i > 0; i--) {
            imagenActual = nekoPics[6];
            repaint();
            pausa(250);
            imagenActual = nekoPics[7];
            repaint();
            pausa(250);
        }
    }

    void pausa(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) { }
    }

    public void paint(Graphics screen) {
        if (imagenActual != null)
            screen.drawImage(imagenActual, x, y, this);
    }
}
