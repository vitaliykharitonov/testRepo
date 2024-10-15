package generics.task5;

// Завдання:
// Напишіть метод copy, який копіює елементи з одного списку в інший,
// використовуючи wildcards для типу даних.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
        public static void main(String[] args) {
            Cat cat1 = new Cat("cat1");
            Cat cat2 = new Cat("cat2");

            List<Cat> cats = Arrays.asList(cat1, cat2);
            copy(cats).forEach(System.out::println);
        }

        public static List copy(List list) {
            List<? extends Animals> animals = new ArrayList<>(list);
            return animals;
        }
}
