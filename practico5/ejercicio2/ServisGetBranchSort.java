package ejercicio2;

import java.util.ArrayList;

public class ServisGetBranchSort {
    private ArrayList<Integer> result;

    public ServisGetBranchSort() {
        this.result = new ArrayList<>();
    }

    public ArrayList<Integer> getBranchSort(Mesa mesa, int origen, int destino) {
        ArrayList<Integer> aux = new ArrayList<>();
        aux.add(origen);
        System.out.println(aux);

        int []posicionesOrigen = mesa.getPosicionValor(origen);
        int xActual = posicionesOrigen[0];
        int yActual = posicionesOrigen [1];
        //encuentra bien los valores iniciales
        return getBranchSortTo(mesa, origen, destino, aux , xActual, yActual);
    }

    private ArrayList<Integer> getBranchSortTo(Mesa mesa, int origen, int destino, ArrayList<Integer> caminoParcial , int xActual, int yActual) {
        ArrayList<Integer> aux = new ArrayList<>(caminoParcial);
        Posicion pos = mesa.getPosicion(xActual,yActual);
        aux.add(origen);
        if (pos.getValor() == destino) {
            if (result.isEmpty() || aux.size() < result.size()) {
                result.clear();
                result.addAll(aux);
                return result;
            }
        }else {
            if (pos != null) {
                ArrayList<Boolean> movimientos = pos.getMovimientos();
                for (int index = 0; index < movimientos.size(); index++) {
                    if (movimientos.get(index)) {
                        aux.add(pos.getValor());
                        if (index == 0 &&movimientos.get(index)!=false) {
                            System.out.println("fui al norte");
                            getBranchSortTo(mesa, pos.getValor(), destino, aux, xActual, yActual - 1);
                        } else if (index == 1  &&movimientos.get(index)!=false) {
                            System.out.println("fui al sur");
                            getBranchSortTo(mesa, pos.getValor(), destino, aux, xActual, yActual + 1);
                        } else if (index == 2  && movimientos.get(index)!=false) {
                            System.out.println("fui al este");
                            getBranchSortTo(mesa, pos.getValor(), destino, aux, xActual +1, yActual);
                        } else if (index == 3  && movimientos.get(index)!=false) {
                            System.out.println("fui al oeste");
                            getBranchSortTo(mesa, pos.getValor(), destino, aux, xActual -1, yActual);
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
