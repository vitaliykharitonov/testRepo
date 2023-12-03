package HomeWorkLesson3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter USD amount: ");
        int usdAmount = scanner.nextInt();
        System.out.println("You has entered: " + usdAmount + " USD");
        scanner.close();

        CurrencyConverter converter = new CurrencyConverter(0.01, 36.55);

        double totalAmount = (double) Math.round(converter.calculateTotalAmount(usdAmount) * 100) / 100;
        System.out.println("Total amount to be paid: " + totalAmount  + " UAH");
    }
}
