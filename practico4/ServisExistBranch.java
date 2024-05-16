import java.util.ArrayList;
import java.util.Iterator;



class ServisExistBranch {

    public ServisExistBranch(){

    }

    public ArrayList<Integer> existBranch(Grafo<Integer> grafo, int destino){
        return  existBranchTo(grafo, destino);
    }

    private ArrayList<Integer> existBranchTo(Grafo<Integer> grafo, int destino){
        ArrayList<Integer> result= new ArrayList<>();
        Iterator<Integer> iteradorVertices = grafo.obtenerVertices();
        
        while (iteradorVertices.hasNext()) {
            Integer vertice= iteradorVertices.next();
            if (existBranc(grafo, destino, vertice)==true) {
                result.add(vertice);
            }
        }
        return result;
    }

    private boolean existBranc(Grafo<Integer> grafo,int destino, int actual){
            Iterator<Integer> aux= grafo.obtenerAdyacentes(actual);
            Boolean ExisteCamino=false;

            while(aux.hasNext()){
                Integer vertice= aux.next();
                if(vertice==destino){
                    ExisteCamino= true;
                    return ExisteCamino;
                }
                else if (grafo.obtenerAdyacentes(vertice)!=null){
                    return existBranc(grafo, destino, vertice);
                }
            }
            return ExisteCamino;
    }
}