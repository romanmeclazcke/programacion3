import java.util.LinkedList;

import javafx.scene.shape.Arc;

public class Vertice {

    private LinkedList<Arco> listaAdyacencia;
    private int value;
    private String color;

    public Vertice(int value) {
        this.value = value;
        this.listaAdyacencia = new LinkedList<Arco>();
    }

    public LinkedList<Arco> getListaAdyacencia() {
        return listaAdyacencia;
    }

  
    public void addAdyacente(Arco arco) {
        this.listaAdyacencia.add(arco);
    }

    public int getValue() {
        return this.value;
    }

    public void deleteArco(int verticeId2) {
        if (this.ListContain(verticeId2)) {
            int index = this.ExistArco(verticeId2);
            if (index != -1) {
                this.listaAdyacencia.remove(index);
            }
        }
    }

    public int ExistArco(int verticeId2) {
        for (int index = 0; index < this.listaAdyacencia.size(); index++) {
            if (this.listaAdyacencia.get(index).getVerticeOrigen() == this.value
                    && this.getListaAdyacencia().get(index).getVerticeDestino() == verticeId2) {
                return index;
            }
        }
        return -1;
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