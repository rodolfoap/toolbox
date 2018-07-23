package org.rap.prgtests.twentyone;

import java.io.*;

public class Day_17_ZeroFile {
    public static void main(String[] arguments) {
        try {
            FileInputStream file = new
                FileInputStream("junkfile.dat");
            boolean eof = false;
            int size = 0;
            while (!eof) {
                int input = file.read();
                if (input == -1)
                    eof = true;
                else
                    size++;
            }
            file.close();
            FileOutputStream outFile = new
                FileOutputStream("junkfile.dat");
            for (int i = 0; i < size; i++)
                outFile.write( (byte)0 );
            outFile.close();
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}
