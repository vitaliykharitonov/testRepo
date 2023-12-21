package HomeWorkLesson8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        class MyException extends RuntimeException {
            public MyException(String message) {
                super(message);
            }
        }

        try {
            FileReader reader = new FileReader("example.txt");
            reader.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FNFException is catched");
        } catch (IOException e) {
            System.out.println("IOException is catched");
        } catch (MyException ex) {
            System.out.println("MyExeption is catched!");
        }
    }
}
