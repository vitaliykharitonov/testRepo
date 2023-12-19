package HomeWorkLesson7;

import java.util.List;

public class SearchResult <E>{
    private E result;
    public void setResult (List<Meal> result) {
        this.result = (E) result;
    }
    public E getResult() {
        return result;
    }

    public void setResult(Pagination pagination) {
        this.result = (E) result;
    }
}