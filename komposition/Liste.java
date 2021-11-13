package school.komposition;

class Liste
{
    private Listenelement erster;
    /**
     * Constructor for objects of class Liste
     */
    Liste ()
    {
        this.erster = null;
    }

    public void hintenEinfuegen(Datenelement konteninhalt){
        erster = erster.hintenEinfuegen(konteninhalt);
    }

    public void listendatenAusgeben(){
        erster.listendatenAusgeben();
    }

    public int gesamtgewichtGeben(){
        return erster.gesamtgewichtGeben();
    }

    public int getLength(){
        return erster.anzahlDatenknotenGeben();
    }

    public Datenelement inhaltLetzterGeben(){
        return erster.inhaltLetzterGeben(null);
    }
}
