import java.util.Hashtable;
import java.util.Iterator;


public class ServisDepthFirstSearch<T> {

    private Hashtable<Integer, String> coloresVertices;


    public ServisDepthFirstSearch(){
        this.coloresVertices= new Hashtable<>();
    }

    public void dfs(Grafo<Integer> grafo){
        Iterator<Integer> iterador= grafo.obtenerVertices();

        while (iterador.hasNext()) {
            int vertice = iterador.next();
            
            this.coloresVertices.put(vertice, "Blanco");
        }

        Iterator<Integer> iterador2= grafo.obtenerVertices();

        while (iterador2.hasNext()) {
            DepthFirstSearch(iterador.next(), grafo);
        }
    }


    private void DepthFirstSearch(int verticeid, Grafo<?> grafo){
        this.coloresVertices.put(verticeid, "Amarillo");

        Iterator<Integer> iteradorAdyacentes = grafo.obtenerAdyacentes(verticeid);

        while (iteradorAdyacentes.hasNext()) {
            Integer aux= iteradorAdyacentes.next();
            if (this.coloresVertices.get(aux)=="Blanco") {
                    DepthFirstSearch(aux,grafo);
            }
        }
        this.coloresVertices.put(verticeid,"Negro");
    }
}
