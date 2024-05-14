import java.util.Iterator;

public class IteratorVertices<T> implements Iterator<Integer> {
    private Iterator<Arco<T>> it; //lista de arcos de un vertice dado

    public IteratorVertices (Iterator<Arco<T>> it) {
        this.it = it;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    
    }

    @Override
    public Integer next() {
        Arco<T> arco = it.next();
        return arco.getVerticeDestino();
        //como el iterador debia retornar int (destino)
        //si tengo un siguente voy pidiendolo
    }
}