public class Leaf<T implements Comparable> extends AbstractNode{

    public boolean contains(T data){
        return false;
    }

    public void list(){
    
    }

    public AbstractNode insert(T data){
        return new Node(data);
    }

    public void remove(T data){

    }
}