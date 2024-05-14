import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;


public class ServisBreadthFirstSearch<T> {

    private Hashtable<Integer,Boolean> listaVertices;
    private LinkedList<Integer> fila;

    public ServisBreadthFirstSearch(){
        this.listaVertices = new Hashtable<>();
        this.fila= new LinkedList<>();
    }

    public void bfs(Grafo<Integer> grafo ){
        this.fila.clear();

        Iterator<Integer> iterador= grafo.obtenerVertices();

        while(iterador.hasNext()){
            this.listaVertices.put(iterador.next(), false);
        }

        Iterator<Integer> iterador2= grafo.obtenerVertices();

        while (iterador2.hasNext()) {
            breadthFirstSearch(grafo, iterador2.next());
        }


    }

    private void breadthFirstSearch(Grafo<Integer> grafo, int verticeId){
        this.listaVertices.put(verticeId, true);
        this.fila.addFirst(verticeId);

        Iterator<Integer> iteradorFila = this.fila.iterator();

        while(iteradorFila.hasNext()){
            Integer remove= this.fila.removeFirst();
            Iterator<Integer> iteradorAdyacentesAlVertice= grafo.obtenerAdyacentes(remove);

            while (iteradorAdyacentesAlVertice.hasNext()) {
                Integer verticeAux = iteradorAdyacentesAlVertice.next();
                this.listaVertices.put(verticeAux, true);
                this.fila.add(verticeAux);
            }
        }
    }
    
}
