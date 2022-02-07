public abstract class AbstractNode<T implements Comparable>{

    public boolean contains(T data);
    public void list();
    public AbstractNode insert(T data);
    public void remove(T data);
}