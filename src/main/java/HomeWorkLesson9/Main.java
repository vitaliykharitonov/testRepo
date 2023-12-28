package HomeWorkLesson9;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int n = 13; //---> Quantity of Fibonacci numbers in sequence (from 1 to 47)
            int[] f = IntStream.rangeClosed(1, n).boxed()
                    .reduce(new int[]{0, 0}, (a, b) -> {
                            System.out.println(a[1]); //---> Sequence output
                            return new int[]{a[1], Math.max(a[0] + a[1], 1)};
                            }, (a, b) -> null);
    }
}
