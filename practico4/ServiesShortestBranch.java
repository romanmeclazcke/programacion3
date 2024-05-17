import java.util.ArrayList;
import java.util.Iterator;



public class ServiesShortestBranch {
    private ArrayList<Integer> bestBranch;

    public ServiesShortestBranch(){
        this.bestBranch= new ArrayList<Integer>();
    }

    public ArrayList<Integer> getShortestBranch(Grafo<Integer> grafo, int origen, int destino){
        this.bestBranch.clear();
        this.bestBranch.add(origen);
        return getShortestBranch(grafo, origen, destino, this.bestBranch);
    }

    private ArrayList<Integer> getShortestBranch(Grafo<Integer> grafo, int origen, int destino, ArrayList<Integer> camino) {
        ArrayList<Integer> aux = new ArrayList<>(camino);
        
    
        if (destino == origen) {
            this.bestBranch.clear();
            this.bestBranch.addAll(aux);
            return this.bestBranch;
        }
        
        
        
        Iterator<Integer> iteradorAdyacentes = grafo.obtenerAdyacentes(origen);
        while (iteradorAdyacentes.hasNext()) {
            Integer vertice = iteradorAdyacentes.next();
            aux.add(vertice);
            getShortestBranch(grafo, vertice, destino, aux);
            aux.remove(vertice);
        }
        
        return this.bestBranch;
    }
    
    
    
}
