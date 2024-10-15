package generics.task6;

// Завдання:
// Реалізуйте метод для створення масиву типу T[] з певною кількістю елементів.


import java.lang.reflect.Array;


public class Main {
        public static void main(String[] args) {

            String[] arr = createArray(String.class, 5);
            System.out.println(arr.getClass() + "\n" + arr.length);
        }

        public static <T> T[] createArray(Class<T> clazz, int i) {
            return (T[]) Array.newInstance(clazz, i);
        }
}
