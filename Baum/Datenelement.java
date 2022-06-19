package school.Baum;

public class Datenelement {

    int value;

    Datenelement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int compare(Datenelement ele) {
        return Integer.compare(this.value, ele.getValue());
    }
}
