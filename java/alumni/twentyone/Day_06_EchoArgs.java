package org.rap.prgtests.twentyone;

class Day_06_EchoArgs {
    public static void main(String[] arguments) {
        for (int i = 0; i < arguments.length; i++) {
            System.out.println("Argument " + i + ": " + arguments[i]);
        }
    }
}
