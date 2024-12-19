package strings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String_regulars {
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

        System.out.println("3. " + input3_1 + " - " + isValidDate(input3_1) + ", " + input3_2 + " - " + isValidDate(input3_2));

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

        String input6 = "This is is a test test sentence.";

        String[] words = input6.toLowerCase().split(" ");
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for (String word: words) {
            if (set.contains(word) && !list.contains(word)) {
                list.add(word);
            } else {
                set.add(word);
            }
        }

        System.out.println("6. " + list);

//        7.    Validate credit card numbers with formats like 1234-5678-9012-3456 or 1234567890123456

        String input7_1 = "1234-5678-9012-3456";
        String input7_2 = "1234-5678-9012";

        System.out.println("7. " + input7_1 + " - " + isValidCreditCard(input7_1) + ", " + input7_2 + " - " + isValidCreditCard(input7_2));

//        8.    Input: "Love #Java and #Regex!"
//              Output: ["#Java", "#Regex"]

        String input8 = "Love #Java and #Regex!";

        List<String> hashtags = new ArrayList<>();
        Pattern pattern8 = Pattern.compile("#\\w+");
        Matcher matcher8 = pattern8.matcher(input8);

        while (matcher8.find()) {
            hashtags.add(matcher8.group());
        }
        System.out.println("8. " + hashtags);

//         9.    Ensure the password has at least one uppercase letter, one lowercase letter,
//               one digit, and one special character, and is at least 8 characters long.

        String input9_1 = "Password123!";
        String input9_2 = "password123";

        System.out.println("9. " + input9_1 + " - " + isValidPassword(input9_1) + ", " + input9_2 + " - " + isValidPassword(input9_2));

//         10.   Input: "There are 3 cats and 5 dogs."
//               Output: [3, 5]

        String input10 = "There are 3 cats and 5 dogs.";

        List<Integer> numbers = new ArrayList<>();
        Pattern pattern10 = Pattern.compile("\\d+");
        Matcher matcher10 = pattern10.matcher(input10);

        while (matcher10.find()) {
            numbers.add(Integer.parseInt(matcher10.group()));
        }
        System.out.println("10. " + numbers);

//        11.    Validate time in 24-hour format (e.g., 23:59 or 00:00)

        String input11_1 = "23:59";
        String input11_2 = "24:00";

        System.out.println("11. " + input11_1 + " - " + isValidTime(input11_1) + ", " + input11_2 + " - " + isValidTime(input11_2));

//        12.   Replace all instances of a word with another word using regex.
//              Input: Replace "dog" with "cat" in "The dog chased the dog."
//              Output: "The cat chased the cat."

        String input12 = "The dog chased the dog.";

        String output12 = input12.replaceAll("\\b" + "dog" + "\\b", "cat");
        System.out.println("12. " + output12);

//        13.   Remove all consecutive duplicate characters.
//              Input: "aaabbcc"
//              Output: "abc"

        String input13 = "aaabbcc";

        StringBuilder output13 = new StringBuilder();

        for (int i = 0; i < input13.length(); i++) {
            if (i == 0 || input13.charAt(i) != input13.charAt(i - 1)) {
                output13.append(input13.charAt(i));
            }
        }

        System.out.println("13. " + output13);

//        14.    Check if a string is a valid MAC address in formats like 00:0a:95:9d:68:16

        String input14_1 = "00:0a:95:9d:68:16";
        String input14_2 = "00:0a:95:9d:68";

        System.out.println("14. " + input14_1 + " - " + isValidMac(input14_1) + ", " + input14_2 + " - " + isValidMac(input14_2));

//        15.    Find valid HTML tags like <div>, <a href="link">, and ignore invalid tags like <1tag>

        String input15 = "<div> Hello <1tag> World <a href=\"link\">Text</a> </div>";

        List<String> tags = new ArrayList<>();
        Pattern pattern15 = Pattern.compile("</?[a-zA-Z][a-zA-Z0-9]*(\\s+[^>]+)?>");
        Matcher matcher15 = pattern15.matcher(input15);

        while (matcher15.find()) {
            tags.add(matcher15.group());
        }
        System.out.println("15. " + tags);

//        16.   Extract the username (before the @) from an email.
//              Input: "example@domain.com"
//              Output: "example"

        String input16 = "example@domain.com";

        String output16 = input16.substring(0, input16.indexOf("@"));
        System.out.println("16. " + output16);

//        17.   Extract all words from a sentence using regex.
//              Input: "Java is fun!"
//              Output: ["Java", "is", "fun"]

        String input17 = "Java is fun!";

        List<String> words17 = new ArrayList<>();
        Pattern pattern17 = Pattern.compile("\\b\\w+\\b");
        Matcher matcher17 = pattern17.matcher(input17);

        while (matcher17.find()) {
            words17.add(matcher17.group());
        }
        System.out.println("17. " + words17);

//        18.    Validate IPv4 addresses like 192.168.1.1 but reject 256.300.1.1.

        String input18_1 = "192.168.1.1";
        String input18_2 = "256.300.1.1";

        System.out.println("18. " + input18_1 + " - " + isValidIp(input18_1) + ", " + input18_2 + " - " + isValidIp(input18_2));

//        19.    Validate email addresses
//               Valid: example@domain.com, user.name@sub.domain.co
//               Invalid: @domain.com, user@domain

        String input19_1 = "example@domain.com";
        String input19_2 = "user.name@sub.domain.co";
        String input19_3 = "@domain.com";
        String input19_4 = "user@domain";

        System.out.println("19. " + input19_1 + " - " + isValidEmail(input19_1) + ", " + input19_2 + " - " + isValidEmail(input19_2));
        System.out.println(input19_3 + " - " + isValidEmail(input19_3) + ", " + input19_4 + " - " + isValidEmail(input19_4));

//        20.   Create your own version of replace(String target, String replacement) without using the built-in method.
//              Input: ("hello world", "world", "Java")
//              Output: "hello Java"

        String input20 = "hello world";
        String target = "world";
        String replacement = "Java";

        StringBuilder output20 = new StringBuilder();
        int index = 0;

        while (index < input20.length()) {
            if (index + target.length() <= input20.length() && input20.substring(index, index + target.length()).equals(target)) {
                output20.append(replacement);
                index += target.length();
            } else {
                output20.append(input20.charAt(index));
                index++;
            }
        }

        System.out.println("20. " + output20);

//        21.   Split a sentence into an array of words using split().
//              Input: "Welcome to Java"
//              Output: ["Welcome", "to", "Java"]

        String input21 = "Welcome to Java";

        String[] array = input21.split(" ");
        System.out.print("21. ");
        for (String output21: array) {
            System.out.println(output21);
        }

//        22.   Replace every space in the string with a hyphen (-)
//              Input: "I love coding"
//              Output: "I-love-coding"

        String input22 = "I love coding";

        String output22 = input22.replaceAll(" ", "-");
        System.out.println("22. " + output22);

//        23.   Verify if a string reads the same backward, ignoring case and spaces.
//              Input: "Racecar"
//              Output: true

        String input23 = "Racecar";

        System.out.println("23. " + isPalindrome(input23));

//        24.   Use StringBuilder or manual iteration to reverse a string.
//              Input: "developer"
//              Output: "repoleved"

        String input24 = "developer";

        String output24 = new StringBuilder(input24).reverse().toString();
        System.out.println("24. " + output24);

    }
    public static String isValidDate(String date) {
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

    public static String isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            return "valid";
        } else {
            return "invalid";
        }
    }

    public static String isValidTime(String time) {
        String regex = "^(?:[01]\\d|2[0-3]):[0-5]\\d$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(time);
        if (matcher.matches()) {
            return "valid";
        } else {
            return "invalid";
        }
    }

    public static String isValidMac(String mac) {
        String regex = "^([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mac);
        if (matcher.matches()) {
            return "valid";
        } else {
            return "invalid";
        }
    }

    public static String isValidIp(String ip) {
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        if (matcher.matches()) {
            return "valid";
        } else {
            return "invalid";
        }
    }

    public static String isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return "valid";
        } else {
            return "invalid";
        }
    }

    public static Boolean isPalindrome(String input) {
        String ignoreCase = input.toLowerCase();
        int left = 0;
        int right = ignoreCase.length() - 1;

        while (left < right) {
            if (ignoreCase.charAt(left) != ignoreCase.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
