package HomeWorkLesson5;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter first fraction: ");
        String fractionString1 = scanner.next();
        System.out.println("Enter second fraction: ");
        String fractionString2 = scanner.next();
        scanner.close();
        String[] fractionParts1 = fractionString1.split("/");
        String[] fractionParts2 = fractionString2.split("/");
        Fraction fraction1 = new Fraction(Integer.parseInt(fractionParts1[0]), Integer.parseInt(fractionParts1[1]));
        Fraction fraction2 = new Fraction(Integer.parseInt(fractionParts2[0]), Integer.parseInt(fractionParts2[1]));

        if (fraction1.equals(fraction2)) {
            System.out.println("Result: true");
        }
        else {
            System.out.println("Result: false");
        }
    }
}
