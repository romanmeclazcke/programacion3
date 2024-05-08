import java.util.LinkedList;

public class Vertice<T> {
    //agregar lista vertices para reducir complejidad en bfs, debido a que sino la complejidad seria de O(n3) ahora es de 0(n2)
    //en el peor de los casos, sino yo debia buscar el vertice apartir del destino del arco lo cual implicaba un for mas
    //(el metodo bfs tiene la misma complejidad que la original);
    private LinkedList<Vertice<T>> verticesAdyacentes;
    private LinkedList<Arco<T>> listaAdyacencia;
    private int value;
    private String color;

    public Vertice(int value) {
        this.value = value;
        this.listaAdyacencia = new LinkedList<Arco<T>>();
    }

    public LinkedList<Arco<T>> getListaAdyacenciaArcos() {
        return listaAdyacencia;
    }

    public LinkedList<Vertice<T>> getListaAdyacenciaVertices() {
        return this.verticesAdyacentes;
    }


    public void addAdyacente(Arco<T> arco, Vertice<T> vertice) {
        this.listaAdyacencia.add(arco);
        this.verticesAdyacentes.add(vertice);
    }

    public int getValue() {
        return this.value;
    }

    public void deleteArco(int verticeId2, Vertice<T> vertice) {
        if (this.ListContain(verticeId2)) {
            int index = this.ExistArco(verticeId2);
            if (index != -1) {
                this.listaAdyacencia.remove(index);
                this.verticesAdyacentes.remove(vertice);
            }
        }
    }

    public int ExistArco(int verticeId2) {
        for (int index = 0; index < this.listaAdyacencia.size(); index++) {
            if (this.listaAdyacencia.get(index).getVerticeOrigen() == this.value
                    && this.getListaAdyacenciaArcos().get(index).getVerticeDestino() == verticeId2) {
                return index;
            }
        }
        return -1;
    }

    public Arco<T> getArco(int vertice2){
        int resultado = this.ExistArco(vertice2);
        if (resultado!=-1) {
            return this.listaAdyacencia.get(resultado);
        }
        return null;
    }

    public boolean ListContain(int verticeId) {
        for (int i = 0; i < this.listaAdyacencia.size(); i++) {
            if (this.listaAdyacencia.get(i).getVerticeDestino() == verticeId) {
                return true;
            }
        }
        return false;
    }

    

    public int getCantArcos() {
        return this.listaAdyacencia.size();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

}