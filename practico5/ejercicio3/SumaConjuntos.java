package ejercicio3;
import java.util.ArrayList;
import java.util.Iterator;

public class SumaConjuntos {
    private ArrayList<ArrayList<Integer>> resultados;

    public SumaConjuntos() {
        this.resultados = new ArrayList<>();
    }

    public ArrayList<ArrayList<Integer>> getSumaConjuntos(ArrayList<Integer> numeros, Integer resultado) {
        for (Integer number : numeros) {
            getSuma(numeros, number, new ArrayList<>(), resultado, number);
        }
        return this.resultados;
    }

    public void getSuma(ArrayList<Integer> numeros, Integer actual, ArrayList<Integer> caminoActual, Integer resultadoFinal, Integer resultadoParcial) {
        caminoActual.add(actual);
        
        if (resultadoParcial==resultadoFinal) {
            this.resultados.add(new ArrayList<>(caminoActual));
        } else if (resultadoParcial < resultadoFinal) {
            Iterator<Integer> iterator = numeros.iterator();
            while (iterator.hasNext()) {
                Integer numero = iterator.next();
                getSuma(numeros, numero, caminoActual, resultadoFinal, resultadoParcial + numero);
            }
        }
        
        caminoActual.remove(actual);
    }
}
