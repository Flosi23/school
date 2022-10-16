package school.Baum;

public class Abschluss extends Baumelement{

    @Override
    public void inorder() {}

    @Override
    public void preorder() {}

    @Override
    public void postorder() {}

    @Override
    public boolean binarySearch(Datenelement searchFor) {
        return false;
    }

    @Override
    public Knoten insert(Datenelement newEle) {
        return new Knoten(newEle, new Abschluss(), this);
    }

    public boolean equals(Baumelement ele) {
        return true;
    }
}
