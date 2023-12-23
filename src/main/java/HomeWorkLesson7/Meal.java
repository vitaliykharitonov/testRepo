package HomeWorkLesson7;

public class Meal implements Comparable<Meal>{
    private String mealName;
    private String eatingType;
    private int cookingTime;


    public Meal(String mealName, String eatingType, int cookingTime) {
        this.mealName = mealName;
        this.eatingType = eatingType;
        this.cookingTime = cookingTime;
    }

    @Override
    public String toString() {
        return  "    {" + "\n" +
                "      \"mealName\": \"" + mealName + "\"," + "\n" +
                "      \"eatingType\": \"" + eatingType + "\"," + "\n" +
                "      \"cookingTime\": \"" + cookingTime + "\"" + "\n" +
                "    },";
    }

    @Override
    public int compareTo(Meal m) {
        return Integer.compare(this.cookingTime, m.cookingTime);
    }
}

