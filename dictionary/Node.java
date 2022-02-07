public class Node<T implements Comparable> extends AbstractNode{

    private T data;
    private AbstractNode left;
    private AbstractNode right;
    
    public Node(T data, AbstractNode left, AbstractNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(T data){
        this.data = data;
        this.left = new Leaf();
        this.right = new Leaf();
    }

    public boolean contains(T data){
        return false;
    }

    public void list(){

    }

    public void insert(T data){

    }

    public void remove(T data){

    }

    public T getData(){
        return data;
    }

    public AbstractNode getLeft(){
        return left;
    }

    public AbstractNode getRight(){
        return right;
    }
}