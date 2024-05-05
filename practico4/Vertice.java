import java.util.LinkedList;

public class Vertice {

    private LinkedList<Vertice> listaAdyacencia;
    private int value;
    private String color;
     

    public Vertice(int value){
        this.value=value;
        this.listaAdyacencia= new LinkedList<Vertice>();
    }

    public void addAdyacente(Vertice v){
        this.listaAdyacencia.add(v);
    }

    public int getValue(){
        return this.value;
    }

    public void deleteArco(int verticeId2) {
       if (this.ListContain(verticeId2)) {
            int posicion = listaAdyacencia.indexOf(verticeId2);
            listaAdyacencia.remove(posicion);
       }
    }


    public boolean ListContain(int verticeId){
        for (Vertice v : listaAdyacencia) {
            if (v.getValue()==verticeId) {
                return true;
            }
        }
        return false;
    }
    
    public LinkedList<Vertice> getList(){
        return this.listaAdyacencia;
    }

    public int getCantArcos() {
        return this.listaAdyacencia.size();
    }

    public void setColor(String color){
        this.color=color;
    }

    public String getColor(){
        return this.color;
    }

    
}