package school.komposition;

public class Datenknoten extends Listenelement
{

    private Listenelement naechster;
    private Datenelement inhalt;
    /**
     * Constructor for objects of class Datenelement
     */
    Datenknoten (Listenelement naechster, Datenelement inhalt){
        this.naechster = naechster;
        this.inhalt = inhalt;
    }

    @Override
    public Listenelement naechsterGeben() {
        return this.naechster;
    }

    @Override
    public Datenelement inhaltGeben() {
        return this.inhalt;
    }

    @Override
    public Datenelement inhaltLetzterGeben(Datenelement aktuellerInhalt){
        return this.naechster.inhaltLetzterGeben(this.inhalt);
    }

    @Override
    public Datenknoten hintenEinfuegen(Datenelement knoteninhalt){
        this.naechster = this.naechster.hintenEinfuegen(knoteninhalt);
        return this;
    }

    @Override
    public int anzahlDatenknotenGeben() {
        return this.naechster.anzahlDatenknotenGeben() + 1;
    }

    @Override
    public int gesamtgewichtGeben() {
        return naechster.gesamtgewichtGeben() + this.inhalt.getWeight();
    }

    @Override
    public void listendatenAusgeben() {
        System.out.println("Inhalt: " + this.inhalt);
        naechster.listendatenAusgeben();
    }
}
