
public class Test
{
    Binaerbaum baum;

    public Test()
    {
        baum = new Binaerbaum();
    }
    
    public void suchen(Datenelement ele){
        baum.suchen(ele);
    }
    
    public void inorderAusgabe(){
        baum.inorder();
    }
    
    public void einfuegen(Datenelement ele){
        baum.einfuegen(ele);
    }

    public static void main(String[] args) {
        Test test = new Test();

        Datenelement to = new Datenelement("to","bis","expressin motion in the direction of");
        Datenelement free = new Datenelement("free", "frei", "able to act as one wishes");
        Datenelement file = new Datenelement("file", "Datei", "file.");
        Datenelement change = new Datenelement("change", "Veränderung", "make different");
        Datenelement feel = new Datenelement("feel", "Gefühl", "bein aware of being touched");

        test.einfuegen(to);
        test.einfuegen(free);
        test.einfuegen(file);
        test.einfuegen(change);
        test.einfuegen(feel);

        test.suchen(new Datenelement("to", "", ""));
        test.suchen(new Datenelement("wont", "", ""));
        test.suchen(new Datenelement("file", "", ""));

        test.inorderAusgabe();
    }
}
