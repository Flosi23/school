public class Datenknoten extends Listenelement {

    private Listenelement next;
    private Datenelement data;

    public Datenknoten(Listenelement next, Datenelement data) {
        this.next = next;
        this.data = data;
    }

    @Override
    public Listenelement hintenEntnehmen() {
       if(next instanceof Abschluss)  {
           return new Abschluss();
       }
       next = next.hintenEntnehmen();
       return this;
    }

    // muss noch implementiert werden
    @Override
    public Datenelement letzterInhaltGeben() {
        return null;
    }
}
