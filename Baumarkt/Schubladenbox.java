package school.baumarkt;

class Schubladenbox extends Bauteil
{

    Bauteil naechster;
    Werkzeug werkzeug;

    Schubladenbox(Werkzeug werkzeug, Bauteil naechster){
        this.werkzeug = werkzeug;
        this.naechster = naechster;
    }

    @Override
    public Werkzeug getWerkzeug() {
        return werkzeug;
    }

    public Bauteil getNaechster() {
        return naechster;
    }

    @Override
    public String buildWerkzeugString(String builder) {
        builder += this.getWerkzeug().getWerkzeugTyp() + ", ";
        return this.getNaechster().buildWerkzeugString(builder);
    }

    public static void main(String[] args) {
        Container container = new Container();
        container.werkzeugHinzufuegen(new Hammer());
        container.werkzeugHinzufuegen(new Bohrer());
        container.werkzeugHinzufuegen(new Rohrzange());
        container.werkzeugeAusgeben();
        container.werkzeugEntnehmen();
        container.werkzeugeAusgeben();
    }
}
