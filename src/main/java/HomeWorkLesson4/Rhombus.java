package HomeWorkLesson4;

public class Rhombus {
    public static void main(String[] args) {
        int rows = 9;
        int n = 0;
        while (n < rows) {
            for (int i = 1; i <= Math.abs((rows-1)/2 - n); i++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= ((rows-1)/2 - Math.abs(((rows-1)/2 - n))) * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
            n++;
        }
    }
}
