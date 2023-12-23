package HomeWorkLesson7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Data<Meal, Exercise> data = new Data<>();
        Pagination pagination = new Pagination(10, 20, 30);

        Meal meal1 = new Meal("Cheese toasts", "Breakfast", 15);
        Meal meal2 = new Meal("Caesar salad", "Lunch", 30);
        Meal meal3 = new Meal("Lasagna", "Dinner", 45);

        Exercise exercise1  = new Exercise("Warm-up", 1, 1);
        Exercise exercise2  = new Exercise("Squats", 20, 70);

        data.setMeal(meal1);
        data.setMeal(meal2);
        data.setMeal(meal3);
        data.setExercise(exercise1);
        data.setExercise(exercise2);

        SearchResult<Data, Pagination> searchResult = new SearchResult<>();
        searchResult.setResult(data, pagination);
        System.out.println(searchResult.getResult());

        System.out.println();
        System.out.println("*** Meal sorting by cooking time ***");
        System.out.println();

        List<Meal> list = new ArrayList<>();
        list.add(meal2);
        list.add(meal3);
        list.add(meal1);

        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
