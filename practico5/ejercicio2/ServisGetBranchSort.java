package ejercicio2;

import java.util.ArrayList;

public class ServisGetBranchSort {
    private ArrayList<Integer> result;

    public ServisGetBranchSort() {
        this.result = new ArrayList<>();
    }

    public ArrayList<Integer> getBranchSort(Mesa mesa, int origen, int destino) {
        int []posicionesOrigen = mesa.getPosicionValor(origen);
        int xActual = posicionesOrigen[0];
        int yActual = posicionesOrigen [1];
        //encuentra bien los valores iniciales
        return getBranchSortTo(mesa, origen, destino, new ArrayList<Integer>() , xActual, yActual);
    }

    private ArrayList<Integer> getBranchSortTo(Mesa mesa, int origen, int destino, ArrayList<Integer> caminoParcial , int xActual, int yActual) {
        ArrayList<Integer> aux = new ArrayList<>(caminoParcial);
        if (origen == destino) {
            if (aux.size() < this.result.size()) {
                this.result.clear();
                this.result.addAll(aux);
            }
        } else {
            Posicion pos = mesa.getPosicion(xActual,yActual);
            if (pos != null) {
                ArrayList<Boolean> movimientos = pos.getMovimientos();
                for (int index = 0; index < movimientos.size(); index++) {
                    if (movimientos.get(index)) {
                        aux.add(pos.getValor());
                     
                        if (index == 0 &&movimientos.get(index)!=false) {
                            getBranchSortTo(mesa, origen, destino, aux, xActual, yActual - 1);
                        } else if (index == 1  &&movimientos.get(index)!=false) {
                            getBranchSortTo(mesa, origen, destino, aux, xActual, yActual + 1);
                        } else if (index == 2  && movimientos.get(index)!=false) {
                            getBranchSortTo(mesa, origen, destino, aux, xActual ++, yActual);
                        } else if (index == 3  && movimientos.get(index)!=false) {
                            getBranchSortTo(mesa, origen, destino, aux, xActual -1, yActual);
                        }
                        
                    }
                    if (!aux.isEmpty()) {
                        aux.remove(aux.size() - 1);
                    }
                    
                }
            }
        }

        return this.result;
    }

}
