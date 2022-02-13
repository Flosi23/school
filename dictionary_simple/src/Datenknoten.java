
public class Datenknoten extends Baumelement
{
    Baumelement lk;
    Baumelement rk;
    Datenelement inhalt;

    public Datenknoten(Baumelement l, Baumelement r, Datenelement i)
    {
        lk = l;
        rk = r;
        inhalt = i;
    }

    public void naechsterLinksSetzen(Baumelement nl){
        lk = nl;
    }

    public void naechsterRechtsSetzen(Baumelement nr){
        rk = nr;
    }

    public Baumelement naechsterLinksGeben(){
        return lk;
    }

    public Baumelement naechsterRechtsGeben(){
        return rk;
    }

    public boolean suchen(Datenelement ele){
        if(inhalt.compareTo(ele) == 0){
            return true;
        }else if(inhalt.compareTo(ele) < 0){
            return lk.suchen(ele);
        }else{
            return rk.suchen(ele);
        }
    }
    
    public void inorder(){
        lk.inorder();
        inhalt.datenAusgeben();
        rk.inorder();
    }
    
    public Baumelement einfuegen(Datenelement ele){
        if(inhalt.compareTo(ele) == 0){
            return this;
        }
        if(inhalt.compareTo(ele) < 0) {
            lk = lk.einfuegen(ele);
        }
        if(inhalt.compareTo(ele) > 0){
            rk = rk.einfuegen(ele);
        }
        return this;
    }
}

