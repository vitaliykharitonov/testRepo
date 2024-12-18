package strings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {
    public static void main(String[] args) {
//        1.    Input: https://www.google.com/search?q=java
//              Output: google.com

        String input1 = "https://www.google.com/search?q=java";
        String output1 = input1.substring(input1.indexOf("www."), input1.indexOf("/", input1.indexOf("www.")));
        System.out.println("1. " + output1);

//        2.    Input: "Hello, World! 123."
//              Output: HelloWorld123

        String input2 = "Hello, World! 123.";
        String output2 = input2.replaceAll("[\\pP\\s]", "");
        System.out.println("2. " + output2);

//        3.    Valid: 31/12/2023
//              Invalid: 32/13/2023

        String input3_1 = "31/12/2023";
        String input3_2 = "32/13/2023";

        System.out.println("3. " + input3_1 + " - " + isValid(input3_1) + ", " + input3_2 + " - " + isValid(input3_2));

//        4.    Valid: #FF5733, #abc
//              Invalid: #12345, #GGG

        String input4_1 = "#FF5733";
        String input4_2 = "#12345";
        String input4_3 = "#abc";
        String input4_4 = "#GGG";

        System.out.println("4. " + input4_1 + " - " + isValidHexa6(input4_1) + ", " + input4_2 + " - " + isValidHexa6(input4_2));
        System.out.println(input4_3 + " - " + isValidHexa3(input4_3) + ", " + input4_4 + " - " + isValidHexa3(input4_4));

//        5.    Input: "Hello! How are you? I am fine."
//              Output: ["Hello!", "How are you?", "I am fine."]

        String input5 = "Hello! How are you? I am fine.";
        String[] output5 = input5.split("(?<=[.!?])\\s+");
        System.out.println("5. " + Arrays.toString(output5));

//        6.    Input: "This is is a test test sentence."
//              Output: ["is", "test"]

//        String input6 = "This is is a test test sentence.";
//        String[] output6 = input5.split("(?<=[.!?])\\s+");
//        System.out.println(Arrays.toString(output6));

//        7.    Validate credit card numbers with formats like 1234-5678-9012-3456 or 1234567890123456

        String input7_1 = "1234-5678-9012-3456";
        String input7_2 = "1234-5678-9012";

        System.out.println("7. " + input7_1 + " - " + isValidCreditCard(input7_1) + ", " + input7_2 + " - " + isValidCreditCard(input7_2));


//        8.    Input: "Love #Java and #Regex!"
//              Output: ["#Java", "#Regex"]

        String input8 = "Love #Java and #Regex!";

        List<String> hashtags = new ArrayList<>();
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(input8);

        while (matcher.find()) {
            hashtags.add(matcher.group());
        }
        System.out.println("8. " + hashtags);

    }
    public static String isValid(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            return "invalid";
        }
        return "valid";
    }

    public static String isValidHexa6(String hexa) {
        Pattern hexa6 = Pattern.compile("^#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$");
        Matcher matcher = hexa6.matcher(hexa);
        if (matcher.matches()) {
            return "valid";
        } else {
            return "invalid";
        }
    }

    public static String isValidHexa3(String hexa) {
        Pattern hexa3 = Pattern.compile("^#([0-9a-fA-F]{3}){1,2}$");
        Matcher matcher = hexa3.matcher(hexa);
        if (matcher.matches()) {
            return "valid";
        } else {
            return "invalid";
        }
    }

    public static String isValidCreditCard(String cardNumber) {
        String regex = "^(\\d{4}-\\d{4}-\\d{4}-\\d{4}|\\d{16})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);
        if (matcher.matches()) {
            return "valid";
        } else {
            return "invalid";
        }
    }

}
