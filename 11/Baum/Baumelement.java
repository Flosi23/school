package school.Baum;

public abstract class Baumelement {

    public abstract void inorder();
    public abstract void preorder();
    public abstract void postorder();
    public abstract boolean binarySearch(Datenelement searchFor);
    public abstract Knoten insert(Datenelement newEle);
}
