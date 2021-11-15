package school.Tower;

import java.awt.*;

public class Abschluss extends Stein {

    Abschluss(){
        super(Color.darkGray);
        this.height = 0.5;
    }

    @Override
    public int anzahlSpielsteineGeben(int counter) {
        return counter;
    }

    @Override
    public void listenDatenAusgeben() {
        this.println();
    }

    @Override
    public double turmhoeheGeben() {
        return this.height;
    }
}
