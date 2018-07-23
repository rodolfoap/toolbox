package org.rap.prgtests.twentyone;

class Day_16_HexRead {
    String[] input = { "000A110D1D260219 ",
        "78700F1318141E0C ",
        "6A197D45B0FFFFFF " };

    public static void main(String[] arguments) {
    	Day_16_HexRead hex = new Day_16_HexRead();
        for (int i = 0; i < hex.input.length; i++)
            hex.readLine(hex.input[i]);
    }

    void readLine(String code) {
        try {
            for (int j = 0; j + 1 < code.length(); j += 2) {
                String sub = code.substring(j, j+2);
                int num = Integer.parseInt(sub, 16);
                if (num == 255)
                    return;
                System.out.print(num + " ");
            }
        } finally {
            System.out.println("**");
        }
        return;
    }
}
