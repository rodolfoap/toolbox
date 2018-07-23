package org.rap.prgtests.twentyone;

public class Day_01_Ellsworth {
    public static void main(String[] arguments) {
       String line1 = "The advancement of the arts, from year\n";
       String line2 = "to year, taxes our credulity, and seems\n";
       String line3 = "to presage the arrival of that period\n";
       String line4 = "when human improvement must end.";
       String quote = line1 + line2 + line3 + line4;
       String speaker = "Henry Ellsworth";
       String title = "U.S. Commissioner of Patents";
       String from = "1843 Annual Report of the Patent Office";
       System.out.println('\u0022' + quote + '\u0022');
       System.out.println("\t" + speaker);
       System.out.println("\t" + title);
       System.out.println("\t" + from);
    }
}

