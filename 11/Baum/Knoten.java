package school.Baum;

public class Knoten extends Baumelement{

    private Datenelement ele;
    private Baumelement left;
    private Baumelement right;

    public Knoten(Datenelement ele, Baumelement left, Baumelement right) {
        this.ele = ele;
        this.left = left;
        this.right = right;
    }

    public Knoten(Datenelement ele){
        this.ele = ele;
        this.left = new Abschluss();
        this.right = new Abschluss();
    }

    @Override
    public void inorder() {
        left.inorder();
        System.out.println(ele.getValue());
        right.inorder();
    }

    @Override
    public void preorder() {
        System.out.println(ele.getValue());
        left.preorder();
        right.preorder();
    }

    @Override
    public void postorder() {
        left.postorder();
        right.postorder();
        System.out.println(ele.getValue());
    }

    @Override
    public boolean binarySearch(Datenelement searchFor) {
        if(ele.compare(searchFor) == 0){
            return true;
        }
        if(searchFor.compare(ele) < 0){
            return left.binarySearch(searchFor);
        }
        if(searchFor.compare(ele) > 0){
            return right.binarySearch(searchFor);
        }
        return false;
    }

    @Override
    public Knoten insert(Datenelement newEle) {
        if(ele.compare(newEle) == 0){
            return this;
        }
        if(newEle.compare(ele) < 0) {
            this.left = left.insert(newEle);
        } else {
            this.right = right.insert(newEle);
        }

        return this;
    }

    public boolean equals(Knoten other) {
        return other.ele.compare(ele) == 0 && left.equals(other.left) && right.equals(other.right);
    }
}
