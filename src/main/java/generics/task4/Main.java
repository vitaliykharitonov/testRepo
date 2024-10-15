package generics.task4;

// Завдання:
// Створіть метод, що приймає тільки об'єкти, які реалізують інтерфейс Comparable,
// і повертає найбільший з них

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            Obj obj1 = new Obj(7);
            Obj obj2 = new Obj(2);
            Obj obj3 = new Obj(5);

            List<Obj> list = Arrays.asList(obj1, obj2, obj3);
            Collections.sort(list);
            System.out.println(list.get(0));
        }
}
