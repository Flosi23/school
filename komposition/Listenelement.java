package school.komposition;

abstract class Listenelement
{
    public abstract Listenelement naechsterGeben();
    public abstract Datenelement inhaltGeben();

    public abstract Datenelement inhaltLetzterGeben(Datenelement aktuellerInhalt);
    public abstract Datenknoten hintenEinfuegen(Datenelement knoteninhalt);
    public abstract int anzahlDatenknotenGeben();
    public abstract int gesamtgewichtGeben();
    public abstract void listendatenAusgeben();
}
