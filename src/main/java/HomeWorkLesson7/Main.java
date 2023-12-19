package HomeWorkLesson7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Meal meal1 = new Meal("Cheese toasts", "Breakfast", 15);
        Meal meal2 = new Meal("Caesar salad", "Lunch", 30);
        Meal meal3 = new Meal("Lasagna", "Dinner", 45);

        Exercise exercise1  = new Exercise("Warm-up", 1, 1);
        Exercise exercise2  = new Exercise("Squats", 20, 70);

        Pagination pagination = new Pagination(10, 20, 30);

        List<Meal> dataMeal = new ArrayList<>();
        dataMeal.add(meal1);
        dataMeal.add(meal2);
        dataMeal.add(meal3);

        List<Exercise> dataExercise = new ArrayList<>();
        dataExercise.add(exercise1);
        dataExercise.add(exercise2);

        SearchResult<Objects> searchResult = new SearchResult<>();
        searchResult.setResult(dataMeal);
        searchResult.setResult(pagination);

        Collections.sort(dataMeal);
        dataMeal.forEach(System.out::println);

    }

}
