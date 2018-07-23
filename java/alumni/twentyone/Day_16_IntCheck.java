package org.rap.prgtests.twentyone;

public class Day_16_IntCheck {
    public static void main(String[] arguments) {
        if (arguments.length == 1) {
            try {
                int number = Integer.parseInt(arguments[0]);
                System.out.println(number + " is an integer.");
            } catch (NumberFormatException nfe) {
                System.out.println(arguments[0] + " is not an integer.");
            }
        }
    }
}
    