
public class Binaerbaum
{
    private Baumelement wurzel;

    public Binaerbaum()
    {
        wurzel = new Abschluss();
    }
    
    public void wurzelSetzen(Baumelement w){
        wurzel = w;
    }
    
    public Baumelement wurzelGeben(){
        return wurzel;
    }
      
    public void suchen(Datenelement ele){
        if(wurzel.suchen(ele)){
            System.out.println("Der Eintrag "+ele+" ist im Baum enthalten.");
        }else{
            System.out.println("Der Eintrag "+ele+" ist NICHT im Baum enthalten.");
        }
    }
    
    public void inorder(){
        wurzel.inorder();
    }
    
    public void einfuegen(Datenelement ele){
        wurzel = wurzel.einfuegen(ele);
    }
}
