package school.dictionary.BST;

public abstract class AbstractNode<T extends Comparable<T>>{

    protected abstract Node<T> findNode(T data);
    protected abstract T getMin(T data);
    public abstract boolean contains(T data);
    public abstract void list();
    public abstract AbstractNode<T> insert(T data);
    public abstract AbstractNode<T> remove(T data);
}