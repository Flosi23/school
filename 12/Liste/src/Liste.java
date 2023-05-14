public class Liste {

    private Listenelement erster;

    public Datenelement hintenEntnehmen(){
        Datenelement ele = erster.letzterInhaltGeben();
        erster = erster.hintenEntnehmen();
        return ele;
    }
}
