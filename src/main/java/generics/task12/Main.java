package generics.task12;

// Завдання:
// Створіть клас з Generics, що працює з enum,
// і реалізуйте метод для повернення enum за його індексом.


import java.util.HashMap;
import java.util.Map;

public class Main {

        public static void main(String[] args) {
            Map<Object, Enum> days = new HashMap<>();
            days.put(0, EnumDays.MONDAY);
            days.put(1, EnumDays.TUESDAY);
            days.put(2, EnumDays.WEDNESDAY);

            System.out.println(days.get(1));
        }
}
