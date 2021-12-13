package school.baumarkt;

public abstract class Werkzeug
{
    public String getWerkzeugTyp(){
        return this.getClass().getSimpleName();
    }
}
