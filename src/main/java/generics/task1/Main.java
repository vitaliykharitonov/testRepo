package generics.task1;

// Завдання:
// Реалізуйте клас Container<T>, що може зберігати значення будь-якого типу та повертати його.

public class Main {
    public static class Container<T extends Object> {
        private T obj;

        public Container(T obj) {
            this.obj = obj;
        }

        public static void main(String[] args) {
            Object obj = "text";
            Container container = new Container(obj);
            System.out.println(container.obj);
        }
    }
}
