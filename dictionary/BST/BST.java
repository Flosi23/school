package school.dictionary.BST;

public class BST<T extends Comparable<T>>{

    private AbstractNode<T> root;

    public BST(){
        root = new Leaf<>();
    }

    public boolean contains(T data){
        return root.contains(data);
    }

    public T search(T data){
        return root.findNode(data).getData();
    }

    public void list(){
        root.list();
    }

    public void insert(T data){
        root = root.insert(data);
    }

    public void remove(T data){
        root = root.remove(data);
    }

    public void setRoot(AbstractNode<T> root) {
        this.root = root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BST<?> bst = (BST<?>) o;
        return root.equals(bst.root);
    }
}