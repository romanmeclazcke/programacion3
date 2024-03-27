import java.util.Iterator;

public class Node<T> implements Iterator<T> {
    private T info;
    private Node<T> next;
    private Node<T> previous;

    public Node() {
        this.info = null;
        this.next = null;
    }

    public Node(T infor, Node<T> next, Node<T> previous) {
        this.setInfo(infor);
        this.setNext(next);
        this.setPrevious(previous);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getNext() {
        return next;
    }
    public Node<T> getPrevious() {
        return previous;
    }
    public void setPrevious(Node<T> s){
        this.previous=s;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        } else {
            return this.getNext().getInfo();
        }
    }

    // @Override
    // public int compareTo(T o) {
    // return this.info.compareTo(String(o));
    // }

}
