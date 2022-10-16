package school.Baum;

public class Baum{

    private Baumelement root;

    Baum(){
        root = new Abschluss();
    }

    public void inorder(){
        root.inorder();
    }

    public void preorder(){
        root.preorder();
    }

    public void postorder(){
        root.postorder();
    }

    public boolean binarySearch(Datenelement searchFor) {
        return root.binarySearch(searchFor);
    }

    public void insert(Datenelement newEle){
        root = root.insert(newEle);
    }

    public boolean equals(Baum baum) {
        return root.equals(baum.root);
    }
}
