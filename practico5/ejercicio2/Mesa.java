package ejercicio2;

public class Mesa {
    private Posicion[][] posiciones;

    public Mesa(Posicion[][] mesa) {
        this.posiciones = mesa;
    }
    

    public Posicion getPosicion(int x, int y){
        return this.posiciones[x][y];
    }

    public int getValor(int x, int y){
        return this.posiciones[x][y].getValor();
    }

    public int[][] getPosicionValor(int valor) {
        int[][] posicion = new int[1][1]; // Array para almacenar la posición encontrada (fila y columna)
        for (int fila = 0; fila < posicion.length-1; fila++) {
            for (int columna = 0; columna < posiciones[0].length-1; columna++) {
                if (posiciones[fila][columna].getValor() == valor) {
                    posicion[0][0] = fila;
                    posicion[0][1] = columna;
                    return posicion; // Retorna la primera posición encontrada
                }
            }
        }
        return null;
    }
    
}
