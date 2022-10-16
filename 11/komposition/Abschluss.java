package school.komposition;

class Abschluss extends Listenelement
{

    /**
     * Constructor for objects of class Abschluss
     */
    Abschluss ()
    {

    }

    @Override
    public Listenelement naechsterGeben() {
        return null;
    }

    @Override
    public Datenelement inhaltGeben() {
        return null;
    }

    @Override
    public Datenelement inhaltLetzterGeben(Datenelement aktuellerInhalt){
        return aktuellerInhalt;
    }

    @Override
    public Datenknoten hintenEinfuegen(Datenelement knoteninhalt){
        return new Datenknoten(this, knoteninhalt);
    }

    @Override
    public int anzahlDatenknotenGeben() {
        return 0;
    }

    @Override
    public int gesamtgewichtGeben() {
        return 0;
    }

    @Override
    public void listendatenAusgeben() {
        System.out.println("-- Ende der Liste --");
    }
}
