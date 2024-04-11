import java.util.Iterator;
import java.util.LinkedList;

public class main {

    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<>();
        MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<>();

      
        lista1.insertFront(44);
        lista1.insertFront(33);
        lista1.insertFront(25);
        lista1.insertFront(22);
        lista1.insertFront(2);

        lista2.insertFront(999);
        lista2.insertFront(232);
        lista2.insertFront(25);
        lista2.insertFront(22);
        lista2.insertFront(5);

        // Mostrar lista1 y lista2 antes de unir
        System.out.println("Lista 1 antes de unir:");
        System.out.println(lista1);
        System.out.println("Lista 2 antes de unir:");
        System.out.println(lista2);

        // Unir las listas ordenadamente
        MySimpleLinkedList<Integer> listaUnidaOrdenada = CreateListUnionOrdenadas(lista1, lista2);

        // Mostrar la lista unida ordenadamente
        System.out.println("Lista unida ordenada:");
        System.out.println(listaUnidaOrdenada);
    }

    public static MySimpleLinkedList<Integer> CreateListUnionOrdenadas(MySimpleLinkedList<Integer> list1,MySimpleLinkedList<Integer> list2) {
        MyIterator<Integer> it1 = list1.iterator();
        MyIterator<Integer> it2 = list2.iterator();

        MySimpleLinkedList<Integer> aux = new MySimpleLinkedList<>();
        while (it1.hasNext()) {
            Integer value1 = it1.get();
            Integer value2 = it2.get();
          
            if (value1==value2) {
                aux.insertFront(value1);
                it1.next();
                it2.next();
            } else {
                if (value1 < value2) {
                    it1.next();
                } else if (value1 > value2) {
                    it2.next();
                }
            }
        }
        return aux;

    }

    // Otros métodos

    public MySimpleLinkedList CreateListUnion(MySimpleLinkedList list1, MySimpleLinkedList list2) {
        MySimpleLinkedList aux = new MySimpleLinkedList();
        for (int a = 0; a < list1.getSize(); a++) {
            int result = list2.indexOf(list1.indexOf(a));
            if (result > 0) {
                aux.insertFront(list1.getIndex(a));
            }
        }
        return aux;

    }

    public MySimpleLinkedList CreateListElementosExlusivos(MySimpleLinkedList a1, MySimpleLinkedList list2) {
        MySimpleLinkedList aux = new MySimpleLinkedList();
        for (int a = 0; a < a1.getSize(); a++) {
            int result = list2.indexOf(a1.indexOf(a));
            if (result < 0) {
                aux.insertFront(a1.getIndex(a));
            }
        }
        return aux;

    }

}
