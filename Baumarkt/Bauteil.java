package school.baumarkt;

abstract class Bauteil
{

    public Werkzeug getWerkzeug(){
        return null;
    }

    public abstract Bauteil getNaechster();

    public abstract String buildWerkzeugString(String builder);
}
