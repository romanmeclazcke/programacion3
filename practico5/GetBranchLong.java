import java.util.ArrayList;
import java.util.Iterator;

class GetBranchLong {
    private ArrayList<Integer> puertas;

    public GetBranchLong() {
        this.puertas = new ArrayList<>();
    }

    public ArrayList<Integer> getBranchLong(Grafo<Integer> grafo, int origen, int destino) {
        return getBranchLonger(grafo, origen, destino, new ArrayList<>());
    }

    private ArrayList<Integer> getBranchLonger(Grafo<Integer> grafo, int origen, int destino, ArrayList<Integer> camino) {
        ArrayList<Integer> aux = new ArrayList<>(camino);
        if (origen == destino) {
            aux.add(origen);
            if (camino.size() > this.puertas.size()) {
                this.puertas.clear();
                this.puertas.addAll(camino);
                return this.puertas;
            }
        } else {
            Iterator<Integer> iteradorAdyacentes = grafo.obtenerAdyacentes(origen);
            while (iteradorAdyacentes.hasNext()) {
                Integer verticeAdyacente = iteradorAdyacentes.next();
                aux.add(verticeAdyacente);
                getBranchLonger(grafo, verticeAdyacente, destino, aux);
                aux.remove(verticeAdyacente);
            }
        }
        return this.puertas;
    }

}