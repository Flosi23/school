package school.dictionary.BST;

public class Leaf<T extends Comparable<T>> extends AbstractNode<T> {

    protected Node<T> findNode(T data){
        return null;
    }

    public boolean contains(T data){
        return false;
    }

    public void list(){}

    public AbstractNode<T> insert(T data){
        return new Node<>(data);
    }

    public AbstractNode<T> remove(T data){
        return this;
    }

    protected T getMin(T data){
        return data;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}