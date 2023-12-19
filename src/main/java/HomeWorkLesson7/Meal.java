package HomeWorkLesson7;

public class Meal implements Comparable<Meal> {
    private String mealName;
    private String eatingType;
    private int cookingTime;


    public Meal(String mealName, String eatingType, int cookingTime) {
        this.mealName = mealName;
        this.eatingType = eatingType;
        this.cookingTime = cookingTime;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getEatingType() {
        return eatingType;
    }

    public void setEatingType(String eatingType) {
        this.eatingType = eatingType;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    @Override
    public int compareTo(Meal m) {
        return Integer.compare(this.cookingTime, m.cookingTime);
    }

    @Override
    public String toString() {
        return "Eating type is: " + this.eatingType + ", Meal is: " + this.mealName + ", Cooking time is: " + this.cookingTime;
    }
}

