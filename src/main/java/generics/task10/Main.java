package generics.task10;

// Завдання:
// Реалізуйте метод, що приймає List<?>
// і виводить елементи цього списку, незалежно від їх типу.


import java.util.Arrays;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            List<Integer> intList = Arrays.asList(1, 2, 3);
            print(intList);
        }
        public static void print(List<?> list) {
            list.forEach(System.out::println);
    }
}
