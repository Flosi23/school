public class BST<T implements Comparable>{

    private AbstractNode root;

    public BST(){
        root = new AbstractNode();
    }

    public boolean contains(T data){
        return root.contains(data);
    }

    public void list(){
        root.list();
    }

    public void insert(T data){
        root.insert(data);
    }

    public void remove(T data){
        root.remove(data);
    }
}