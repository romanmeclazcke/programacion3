import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public MySimpleLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> temp = new Node<T>(info, null, null);
        if (this.firstNode != null) {
            temp.setNext(this.firstNode);
            this.firstNode.setPrevious(temp);
        }
        this.firstNode = temp;
        if (this.lastNode == null) {
            this.lastNode = temp;
        }
        this.size = this.size + 1;
    }

    public Node<T> extractFront() {
        return this.firstNode;
    }

    public void deleteFirst() {
        // le pido al primero el nodo siguente
        Node<T> aux = firstNode.getNext();
        aux.setPrevious(null);
        firstNode = aux;
        // actualizo el primero entonces se pierde la ref del primero(se borra)
        this.size = this.size - 1;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public Node<T> getIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> aux = this.firstNode;
        if (index < size / 2) {
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
        } else {
            aux = this.lastNode;
            for (int i = size - 1; i > index; i--) {
                aux = aux.getPrevious();
            }
        }
        return aux;
    }

    public int indexOf(T node) {
        int contador = 0;
        Node<T> aux = this.firstNode;
        for (int i = 0; i < size; i++) {
            if (aux.getInfo().equals(node)) {
                return contador;
            }
            contador++;
            aux = aux.getNext();
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyIterator<T>(firstNode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = firstNode;
        while (current != null) {
            sb.append(current.getInfo());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

}

// ejercicio2
// 1)INSERTAR AL PRINCIPIO =====> array: o(n) lista:o(1)
// 2)BUSCAR ELEMENTO EN UNA POSICION array ====> o(1) lista:o(n)
// 3)DETERMINAR LA CANTIDAD DE ELEMENTOS array ====>o(1) lista:o(1)
// 4) BORRAR UN ELEMENTO EN UNA POSICON DETERMINADA ====> array:o1 lista:on
//
