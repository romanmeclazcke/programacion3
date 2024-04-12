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

        MySimpleLinkedList<Integer> listaNounion = CreateListElementosExlusivos(lista1, lista2);
        // Unir las listas ordenadamente
       // MySimpleLinkedList<Integer> listaUnidaOrdenada = CreateListUnionOrdenadas(lista1, lista2);

        // Mostrar la lista unida ordenadamente
        System.out.println("Lista unida ordenada:");
        System.out.println(listaNounion);
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


    public static MySimpleLinkedList<Integer> CreateListElementosExlusivos(MySimpleLinkedList<Integer> list1, MySimpleLinkedList<Integer> list2) {
        MySimpleLinkedList<Integer> aux = new MySimpleLinkedList<>();
        MyIterator<Integer> it1 = list1.iterator();
        MyIterator<Integer> it2 = list2.iterator();
        while (it1.hasNext()) {
            Integer n1 = it1.get();
            if (list2.indexOf(n1) == -1) {
                aux.insertFront(n1);
            }
            it1.next();
        }
    
        
        while (it2.hasNext()) {
            Integer n2 = it2.get();
            if (list1.indexOf(n2) == -1) {
                aux.insertFront(n2);
            }
            it2.next();
        }
    
        return aux;
    }
    

}
