package generics.task9;

// Завдання:
// Напишіть метод, що приймає список об'єктів типу <? extends Number>
// і повертає суму всіх елементів.


import java.util.Arrays;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            List<Integer> intList = Arrays.asList(1, 2, 3);
            System.out.println(Sum(intList));
        }
        public static Long Sum(List<? extends Number> list) {
            return list.stream().mapToLong(Number::longValue).sum();
    }
}
