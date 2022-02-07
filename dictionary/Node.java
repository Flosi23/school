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

    public void list(){
        left.list();
        System.out.println(data);
        right.list();
    }

    public boolean contains(T data){
        if(data.equals(this.data)){
            return true;
        }
        if(data.compareTo(this.data) < 0){
            return left.contains(data);
        }
        if(data.compareTo(this.data) > 0){
            return right.contains(data);
        }
        return false;
    }

    public AbstractNode insert(T data){
        if(data.equals(this.data)){
            return this;
        }
        if(data.compareTo(this.data) < 0){
            left = left.insert(data);
        }
        if(data.compareTo(this.data) > 0){
            right = right.insert(data);
        }
        return this;
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