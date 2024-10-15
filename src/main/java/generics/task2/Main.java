package generics.task2;

// Завдання:
// Напишіть метод swap(T[] array, int index1, int index2),
// який міняє місцями два елементи в масиві.

import java.util.Arrays;

public class Main {
        public static void main(String[] args) {
            int[] array = {1, 2, 3};
            swap(array, 0, 2);
        }

        public static void swap(int[] array, int index1, int index2) {
            var i = array[index1];
            array[index1] = array[index2];
            array[index2] = i;
            System.out.println(Arrays.toString(array));
        }
}
