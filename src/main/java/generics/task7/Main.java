package generics.task7;

// Завдання:
// Напишіть метод, який перевіряє,
// чи є переданий об'єкт екземпляром певного generic типу (instanceof з Generics).


public class Main {
    public static void main(String[] args) {

        Obj obj = new Obj();
        System.out.println(check(obj));
    }

    public static class Obj {
        public Obj() {
        }
    }

    public static Boolean check(Obj obj) {
    return obj instanceof Obj;
    }
}
