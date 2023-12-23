package HomeWorkLesson7;

public class SearchResult <T, V>{
    private String string = "";
    public String getResult() {
        return string;
    }
    public void setResult (T t, V v){
        this.string = "{" + this.string + "\n" + t.toString() + "\n" + v.toString() + "\n" + "}";
    }
}
