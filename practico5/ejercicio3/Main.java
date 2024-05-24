package ejercicio3;

import java.util.ArrayList;

public class Main {
    

    public static void main(String[] args) {
        ArrayList<Integer> aux = new ArrayList<>();
        aux.add(1);
        aux.add(2);
        aux.add(3);
        aux.add(4);
        aux.add(5);
        aux.add(6);
        aux.add(7);
        aux.add(8);
        aux.add(9);
        aux.add(10);

        SumaConjuntos  sumaconjuntos = new SumaConjuntos();

        System.out.println(sumaconjuntos.getSumaConjuntos(aux, 4));
    }

    
    
}
