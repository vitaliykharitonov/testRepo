package HomeWorkLesson4;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] array = {2, 5, 3, 1, -7, 4, 17, 4};
        int temp;
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        System.out.print(Arrays.toString(array));
    }
}
