
public class Abschluss extends Baumelement
{
     public void naechsterLinksSetzen(Baumelement nl){
    }

    public void naechsterRechtsSetzen(Baumelement nr){
    }

    public Baumelement naechsterLinksGeben(){
        System.out.println("Kein linker Nachfolger");
        return this;
    }

    public Baumelement naechsterRechtsGeben(){
        System.out.println("Kein rechter Nachfolger");
        return this;
    }

    public boolean suchen(Datenelement ele){
        return false;
    }

    public void inorder(){
    }

    public Baumelement einfuegen(Datenelement ele){
        return new Datenknoten(this, new Abschluss(), ele);
    }
}

