package school.Tower;

import java.awt.*;

public abstract class Stein {
    protected double height;
    protected Color color;

    Stein(Color color){
        this.color = color;
    }

    public abstract int anzahlSpielsteineGeben(int counter);

    public abstract void listenDatenAusgeben();

    public abstract double turmhoeheGeben();

    protected void println(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Stein{" +
                "height=" + height +
                ", color=" + color +
                '}';
    }
}
