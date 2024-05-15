import java.util.Iterator;
import java.util.LinkedList;

public class ServisLongestBranch {



    public  LinkedList<Integer> ServisLongestBranch(Grafo<Integer> grafo, int origen, int destino){
             return LongetBranch(grafo, origen, destino);
    }

    private LinkedList<Integer> LongetBranch(Grafo<Integer> grafo, int origen, int destino) {
        Iterator<Integer> iteradorAdyacentes = grafo.obtenerAdyacentes(origen);
        LinkedList<Integer> result = new LinkedList<>();
    
        while (iteradorAdyacentes.hasNext()) {
            Integer vertice = iteradorAdyacentes.next();
            LinkedList<Integer> aux = new LinkedList<>();
    
            if (vertice == destino) {
                aux.add(vertice);
                aux.add(origen); // Agregar el vértice actual
                return aux;
            }
    
            aux = LongetBranch(grafo, vertice, destino);
            aux.addFirst(origen);
            if (aux.size() > result.size()) {
                result = aux;
            }
        }
        return result;
    }
    
    
}
