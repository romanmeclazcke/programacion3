package ejercicio2;
public class Main2 {
    public static void main(String[] args) {
        // Crear una matriz de posiciones para la mesa (4x4 en este ejemplo)
        Posicion[][] matriz = {
            {new Posicion(1, false, true, false, true), new Posicion(2, false, false, false, true), new Posicion(3, false, false, false, false), new Posicion(4, false, false, false, false)},
            {new Posicion(5, false, true, true, false), new Posicion(6, false, false, false, true), new Posicion(7, false, false, false, false), new Posicion(8, true, false, false, false)},
            {new Posicion(9, false, true, false, true), new Posicion(10, false, true, true, false), new Posicion(11, true, false, false, true), new Posicion(12, false, true, false, false)},
            {new Posicion(13, true, false, true, false), new Posicion(14, true, false, false, false), new Posicion(15, false, false, true, false), new Posicion(16, true, false, false, true)}
        };

        // Crear una instancia de la clase Mesa con la matriz de posiciones
        Mesa mesa = new Mesa(matriz);

        // Crear una instancia de la clase ServisGetBranchSort
        ServisGetBranchSort servicio = new ServisGetBranchSort();

        // Definir el origen y el destino
       

        // Obtener el camino más corto entre el origen y el destino
        System.out.println(servicio.getBranchSort(mesa, 1, 5));

       
    }
}
