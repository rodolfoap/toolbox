package org.rap.prgtests.twentyone;

class Day_02_VolcanoRobot {
    String status;
    int speed;
    float temperature;

    void checkTemperature() {
        if (temperature > 660) {
            status = "returning home";
            speed = 5;
        }
    }

    void showAttributes() {
        System.out.println("Status: " + status);
        System.out.println("Speed: " + speed);
        System.out.println("Temperature: " + temperature);
    }

    public static void main(String[] arguments) {
    	Day_02_VolcanoRobot dante = new Day_02_VolcanoRobot();
        dante.status = "exploring";
        dante.speed = 2;
        dante.temperature = 510;

        dante.showAttributes();
        System.out.println("Increasing speed to 3.");
        dante.speed = 3;
        dante.showAttributes();
        System.out.println("Changing temperature to 670.");
        dante.temperature = 670;
        dante.showAttributes();
        System.out.println("Checking the temperature.");
        dante.checkTemperature();
        dante.showAttributes();
    }
}
