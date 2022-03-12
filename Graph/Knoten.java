package school.Graph;

import java.util.Objects;

public class Knoten<T>{

    private T inhalt;

    public Knoten(T inhalt){
        this.inhalt = inhalt;
    }

    public T getInhalt() {
        return inhalt;
    }

    public void setInhalt(T inhalt) {
        this.inhalt = inhalt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knoten<T> knoten = (Knoten<T>) o;
        return Objects.equals(inhalt, knoten.inhalt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inhalt);
    }

    @Override
    public String toString() {
        return inhalt.toString();
    }
}
