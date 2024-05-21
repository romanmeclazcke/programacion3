package ejercicio2;

import java.util.ArrayList;

public class Posicion {
    private int valor;
    Boolean norte, sur,este,oeste;

    public Posicion(int valor, boolean norte, boolean sur, boolean este,boolean oeste ){
        this.valor=valor;
        this.norte=norte;
        this.sur=sur;
        this.este=este;
        this.oeste=oeste;
    }

    public int getValor(){
        return this.valor;
    }


    public ArrayList<Boolean> getMovimientos(){
        ArrayList<Boolean> movimientos = new ArrayList<>();
        movimientos.add(this.norte);
        movimientos.add(this.sur);
        movimientos.add(this.este);
        movimientos.add(this.oeste);
        return movimientos;
    }

   


    
}
