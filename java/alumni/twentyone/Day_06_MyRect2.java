package org.rap.prgtests.twentyone;

import java.awt.Point;

class Day_06_MyRect2 {
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    Day_06_MyRect2(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    Day_06_MyRect2(Point topLeft, Point bottomRight) {
        x1 = topLeft.x;
        y1 = topLeft.y;
        x2 = bottomRight.x;
        y2 = bottomRight.y;
    }

    Day_06_MyRect2(Point topLeft, int w, int h) {
        x1 = topLeft.x;
        y1 = topLeft.y;
        x2 = (x1 + w);
        y2 = (y1 + h);
    }

    void printRect() {
        System.out.print("MyRect: <" + x1 + ", " + y1);
        System.out.println(", " + x2 + ", " + y2 + ">");
    }

    public static void main(String[] arguments) {
    	Day_06_MyRect2 rect;

        System.out.println("Calling MyRect2 with coordinates 25,25 50,50:");
        rect = new Day_06_MyRect2(25, 25, 50,50);
        rect.printRect();
        System.out.println("***");

        System.out.println("Calling MyRect2 with points (10,10), (20,20):");
        rect= new Day_06_MyRect2(new Point(10,10), new Point(20,20));
        rect.printRect();
        System.out.println("***");

        System.out.print("Calling MyRect2 with 1 point (10,10)");
        System.out.println(" width (50) and height (50):");
        rect = new Day_06_MyRect2(new Point(10,10), 50, 50);
        rect.printRect();
        System.out.println("***");

    }
}
