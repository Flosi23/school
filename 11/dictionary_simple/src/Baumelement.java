
public abstract class Baumelement
{ 
    public abstract void naechsterLinksSetzen(Baumelement nl);
    public abstract void naechsterRechtsSetzen(Baumelement nr);
     
    public abstract Baumelement naechsterLinksGeben();
    public abstract Baumelement naechsterRechtsGeben();

    abstract boolean suchen(Datenelement ele);
    
    public abstract void inorder();

    public abstract Baumelement einfuegen(Datenelement ele);
}
