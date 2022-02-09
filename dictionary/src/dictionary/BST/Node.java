package dictionary.BST;

import java.util.List;

public class Node<T extends Comparable<T>> extends AbstractNode<T> {

    private T data;
    private AbstractNode<T> left;
    private AbstractNode<T> right;

    public Node(T data){
        this.data = data;
        this.left = new Leaf<>();
        this.right = new Leaf<>();
    }

    public void list(){
        left.list();
        System.out.println(data);
        right.list();
    }

    public void addToList(List<T> list){
        left.addToList(list);
        list.add(data);
        right.addToList(list);
    }

    protected Node<T> findNode(T data){
        if(data.equals(this.data)){
            return this;
        }
        if(data.compareTo(this.data) < 0){
            return left.findNode(data);
        }
        if(data.compareTo(this.data) > 0){
            return right.findNode(data);
        }
        return null;
    }

    public boolean contains(T data){
        return this.findNode(data) != null;
    }

    public AbstractNode<T> insert(T data){
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

    public AbstractNode<T> remove(T data){
        if(data.equals(this.data)){
            int numberOfChildren = numberOfChildren();

            if(numberOfChildren == 0){
                return new Leaf<>();
            }
            if(numberOfChildren == 1){
                return left instanceof Leaf<T> ? right : left;
            }
            if(numberOfChildren == 2){
                this.data = right.getMin(this.data);
                right = right.remove(this.data);
                return this;
            }
        }
        if(data.compareTo(this.data) < 0){
            left = left.remove(data);
        }
        if(data.compareTo(this.data) > 0){
            right = right.remove(data);
        }
        return this;
    }

    protected T getMin(T data){
        return left.getMin(this.data);
    }

    private int numberOfChildren(){
        boolean isLeftLeaf = left instanceof Leaf<T>;
        boolean isRightLeaf = right instanceof Leaf<T>;

        if(!isLeftLeaf && !isRightLeaf){
            return 2;
        }
        if(!isLeftLeaf || !isRightLeaf){
            return 1;
        }
        return 0;
    }

    public T getData() {
        return data;
    }

    public void setLeft(AbstractNode<T> left) {
        this.left = left;
    }

    public void setRight(AbstractNode<T> right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return data.equals(node.data) && left.equals(node.left) && right.equals(node.right);
    }

}