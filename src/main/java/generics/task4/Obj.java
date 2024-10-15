package generics.task4;


public class Obj implements Comparable<Obj>{
    private int number;

    public Obj(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(Obj m) {
        return Integer.compare(m.number, this.number);
    }
}
