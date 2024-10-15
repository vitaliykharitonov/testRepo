package generics.task8;

// Завдання:
// Створіть клас Box<T>, який може зберігати об'єкти будь-якого типу,
// і метод get для отримання значення та метод set для встановлення значення.


public class Main {
    public static class Box<T> {
        private T content;

        public Box(T content) {
            this.content = content;
        }

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        public static void main(String[] args) {
            Box<String> stringBox = new Box<>("text");
            System.out.println(stringBox.getContent());
        }
    }
}
