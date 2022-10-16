package school.Tower;
import java.awt.*;

public class Baustein extends Stein {

    private Stein next;

    Baustein(Stein next, double height, Color color){
        super(color);
        this.height = height;
        this.next = next;
    }

    @Override
    public int anzahlSpielsteineGeben(int counter) {
        counter++;
        return this.next.anzahlSpielsteineGeben(counter);
    }

    @Override
    public void listenDatenAusgeben() {
        this.println();
        this.next.listenDatenAusgeben();
    }

    @Override
    public double turmhoeheGeben() {
        return this.height + this.next.turmhoeheGeben();
    }
}
