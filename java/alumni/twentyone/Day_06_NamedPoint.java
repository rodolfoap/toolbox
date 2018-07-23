package org.rap.prgtests.twentyone;

import java.awt.Point;
 
class Day_06_NamedPoint extends Point {
    String name;

    Day_06_NamedPoint(int x, int y, String name) {
        super(x,y);
        this.name = name;
    }

    public static void main(String[] arguments) {
    	Day_06_NamedPoint np = new Day_06_NamedPoint(5, 5, "SmallPoint");
        System.out.println("x is " + np.x);
        System.out.println("y is " + np.y);
        System.out.println("Name is " + np.name);
    }
}
