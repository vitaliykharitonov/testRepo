package generics.task3;

// Завдання:
// Напишіть метод, що приймає список будь-якого типу (List<?>)
// і виводить усі його елементи на консоль.

import java.util.Arrays;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            List<?> list = Arrays.asList("text", 23, true);
            System.out.println(list);
        }
}
