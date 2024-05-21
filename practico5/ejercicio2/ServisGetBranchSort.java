package ejercicio2;

import java.util.ArrayList;

public class ServisGetBranchSort {
    private ArrayList<Integer> result;

    public ServisGetBranchSort() {
        this.result = new ArrayList<>();
    }

    public ArrayList<Integer> getBranchSort(Mesa mesa, int origen, int destino) {
        int [][] posicionesOrigen = mesa.getPosicionValor(origen);
        System.out.println(posicionesOrigen);
        int xActual = posicionesOrigen[0][0];
        int yActual = posicionesOrigen [0][1];
        return getBranchSortTo(mesa, origen, destino, new ArrayList<Integer>() , xActual, yActual);
    }

    private ArrayList<Integer> getBranchSortTo(Mesa mesa, int origen, int destino, ArrayList<Integer> caminoParcial , int xActual, int yActual) {
        ArrayList<Integer> aux = new ArrayList<>(caminoParcial);
        
        if (origen == destino) {
            if (aux.size() < this.result.size()) {
                result.clear();
                result.addAll(aux);
            }
        } else {
            int[][] posiciones = mesa.getPosicionValor(origen);
            Posicion pos = mesa.getPosicion(posiciones[0][0], posiciones[0][1]);
            if (pos != null) {
                ArrayList<Boolean> movimientos = pos.getMovimientos();
                for (int index = 0; index < movimientos.size(); index++) {
                    if (movimientos.get(index)) {
                        aux.add(pos.getValor());
                        if (index == 0) {
                            getBranchSortTo(mesa, origen, destino, aux, xActual, yActual - 1);
                        } else if (index == 1) {
                            getBranchSortTo(mesa, origen, destino, aux, xActual, yActual + 1);
                        } else if (index == 2) {
                            getBranchSortTo(mesa, origen, destino, aux, xActual - 1, yActual);
                        } else {
                            getBranchSortTo(mesa, origen, destino, aux, xActual + 1, yActual);
                        }
                        
                    }
                    aux.remove(pos.getValor());
                }
            }
        }

        return this.result;
    }

}
