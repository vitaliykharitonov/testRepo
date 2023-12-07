package HomeWorkLesson4;

public class Triangle {
    public static void main(String[] args) {
        int rows = 5;
        int n = 0;
        while (n < rows) {
            for (int i = 1; i < rows - n; i++) {
                System.out.print(" ");

            }
            for (int j = 1; j <= n * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
            n++;
        }
    }
}
