package HomeWorkLesson7;

public class Exercise {
    private String exerciseName;
    private int repetitions;
    private int duration;

    public Exercise(String exerciseName, int repetitions, int duration) {
        this.exerciseName = exerciseName;
        this.repetitions = repetitions;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "    {" + "\n" +
                "      \"exerciseName\": \"" + exerciseName + "\"," + "\n" +
                "      \"repetitions\": \"" + repetitions + "\"," + "\n" +
                "      \"duration\": \"" + duration + "\"" + "\n" +
                "    },";
    }
}


