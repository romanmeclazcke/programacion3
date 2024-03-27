import java.util.LinkedList;

public class main {
    public static void main(String[] args) {
        
        
    }



    public  MySimpleLinkedList CreateListUnion(MySimpleLinkedList a1, MySimpleLinkedList a2){
        MySimpleLinkedList aux= new MySimpleLinkedList();
        for(int a=0;a<a1.getSize();a++){
            int result= a2.indexOf(a1.indexOf(a));
            if(result>0){
                aux.insertFront(a1.getIndex(a));
            }
        }
        return aux;

    }

    public  MySimpleLinkedList CreateListElementosExlusivos(MySimpleLinkedList a1, MySimpleLinkedList a2){
        MySimpleLinkedList aux= new MySimpleLinkedList();
        for(int a=0;a<a1.getSize();a++){
            int result= a2.indexOf(a1.indexOf(a));
            if(result<0){
                aux.insertFront(a1.getIndex(a));
            }
        }
        return aux;

    }
    
}
