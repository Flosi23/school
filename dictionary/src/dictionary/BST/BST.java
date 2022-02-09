package dictionary.BST;

import java.util.LinkedList;
import java.util.List;

public class BST<T extends Comparable<T>>{

    private AbstractNode<T> root;

    public BST(){
        root = new Leaf<>();
    }

    public boolean contains(T data){
        return root.contains(data);
    }

    public T search(T data){
        Node<T> node = root.findNode(data);

        if(node == null){
            return null;
        }

        return node.getData();
    }

    public void list(){
        root.list();
    }

    public List<T> toList(){
        List<T> list = new LinkedList<>();
        root.addToList(list);
        return list;
    }

    public int size(){
        return toList().size();
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