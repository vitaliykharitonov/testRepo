package generics.task11;

// Завдання:
// Реалізуйте клас Pair<K, V>, що зберігає два об'єкти різних типів
// і методи для отримання кожного з них.


public class Main {

        public static class Pair<K, V> {
            private K content1;
            private V content2;

            public Pair(K content1, V content2) {
                this.content1 = content1;
                this.content2 = content2;
            }

            public K getContent1() {
                return content1;
            }

            public V getContent2() {
                return content2;
            }
        }

        public static void main(String[] args) {
            Pair<Integer, String> pair = new Pair<>(4, "text");
            System.out.println(pair.getContent1() + "\n" + pair.getContent2());
        }
}
