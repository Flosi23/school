package school.Tower;

public class Turm {

    private Stein first;

    Turm(){
        this.first = new Abschluss();
    }

    public int anzahlSpielsteineGeben(){
        return this.first.anzahlSpielsteineGeben(0);
    }

    public void listenDatenAusgeben(){
        this.first.listenDatenAusgeben();
    }

    public double turmhoeheGeben(){
        return this.first.turmhoeheGeben();
    }
}
