package org.rap.prgtests.twentyone;

public class Day_15_CountInstances {
    private static int numInstances = 0;

    protected static int getNumInstances() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }

    Day_15_CountInstances() {
    	Day_15_CountInstances.addInstance();
    }

    public static void main(String[] arguments) {
        System.out.println("Starting with " +
        		Day_15_CountInstances.getNumInstances() + " instances");
        for (int  i = 0; i < 10; ++i)
            new Day_15_CountInstances();
        System.out.println("Created " +
        		Day_15_CountInstances.getNumInstances() + " instances");
    }
}

