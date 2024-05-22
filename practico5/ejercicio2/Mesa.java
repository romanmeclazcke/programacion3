package ejercicio2;

public class Mesa {
    private Posicion[][] posiciones;

    public Mesa(Posicion[][] mesa) {
        this.posiciones = mesa;
    }

    public Posicion getPosicion(int x, int y) {
        return this.posiciones[x][y];
    }

    public int getValor(int x, int y) {
        return this.posiciones[x][y-1].getValor();
    }

    public int[] getPosicionValor(int valor) {
        int[] posicion = new int[2];

        for (int i = 0; i < this.posiciones.length; i++) {
            for (int j = 0; j < this.posiciones[0].length; j++) {
                if (this.posiciones[i][j].getValor() == valor) {
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        }
        return posicion;
    }

}
