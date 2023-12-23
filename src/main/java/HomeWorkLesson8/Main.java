package HomeWorkLesson8;

import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        String fileName = "example.txt";
        try {
            FileReader reader = new FileReader(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new MyException("MyException is thrown!");
        } finally {
            System.out.println("Program is still working!");
        }
    }
}

class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}
