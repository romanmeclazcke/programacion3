import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ServisLongestBranch {
    private ArrayList<Integer> mejorCamino;
    

    public  LinkedList<Integer> getLongestBranch(Grafo<Integer> grafo, int origen, int destino){
             return LongetBranch(grafo, origen, destino);
    }

    public ArrayList<Integer> getLongestBranchBactracking(Grafo<Integer> grafo, int origen, int destino){
        this.mejorCamino= new ArrayList<>();
        return getLongestBranchBactracking(grafo,origen,destino,this.mejorCamino);
    }

    private LinkedList<Integer> LongetBranch(Grafo<Integer> grafo, int origen, int destino) {
        Iterator<Integer> iteradorAdyacentes = grafo.obtenerAdyacentes(origen);
        LinkedList<Integer> result = new LinkedList<>();
    
        while (iteradorAdyacentes.hasNext()) {
            Integer vertice = iteradorAdyacentes.next();
            LinkedList<Integer> aux = new LinkedList<>();
    
            if (vertice == destino) {
                aux.addFirst(vertice);
                aux.addFirst(origen); // Agregar el vértice actual
                return aux;
            }

            aux = LongetBranch(grafo, vertice, destino);
            
            if (aux.size() > result.size()) {
                aux.addFirst(origen);
                result = aux;
            }
        }
        return result;
    }

    private ArrayList<Integer> getLongestBranchBactracking(Grafo<Integer> grafo, int origen, int destino, ArrayList<Integer> camino) {
        ArrayList<Integer> mejorCaminoTemp = new ArrayList<>(camino);
        if (origen == destino) {
            mejorCaminoTemp.add(origen);
            if (mejorCaminoTemp.size() > this.mejorCamino.size()) {
                this.mejorCamino.clear();
                this.mejorCamino.addAll(camino);
                return this.mejorCamino;
            }
        } else {
            Iterator<Integer> iteradorAdyacentes = grafo.obtenerAdyacentes(origen);
            while (iteradorAdyacentes.hasNext()) {
                Integer vertice = iteradorAdyacentes.next();
                mejorCaminoTemp.add(vertice);
                getLongestBranchBactracking(grafo, vertice, destino,mejorCaminoTemp);
                mejorCaminoTemp.remove(vertice);
            }; 
        }
        return this.mejorCamino;
    }
    

    
    
    
}
