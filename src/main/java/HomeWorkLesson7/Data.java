package HomeWorkLesson7;

public class Data <T, V>{
    private String string = "";
    public String getResult() {
        return string;
    }
    public void setMeal (T t){
        this.string = this.string + "\n" + t.toString();
    }
    public void setExercise (V v){
        this.string = this.string + "\n" + v.toString();
    }

    @Override
    public String toString() {
        return "  \"data\": [" +
                 string + "\n" +
                "  ],";
    }
}
