package school.baumarkt;

class Container
{
    private Bauteil erster;
    /**
     * Constructor for objects of class Liste
     */
    Container() {
        this.erster = new Rollgestell();
    }

    public void werkzeugHinzufuegen(Werkzeug werkzeug){
        erster = new Schubladenbox(werkzeug, erster);
    }

    public Werkzeug werkzeugEntnehmen(){
        Werkzeug werkzeug = erster.getWerkzeug();
        erster = erster.getNaechster();
        return werkzeug;
    }

    public void werkzeugeAusgeben(){
        String werkzeuge = erster.buildWerkzeugString("");
        System.out.println(werkzeuge);
    }
}
