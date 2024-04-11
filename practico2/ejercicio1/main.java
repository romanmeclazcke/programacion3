class main{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Ejemplo de arreglo ordenado
        System.out.println(Ordenado(arr, 0, arr.length - 1));

        
    }

    public static boolean Ordenado(int[] arr, int inicio, int fin) {
        // Condición base: si llegamos al final del arreglo o tenemos un solo elemento, está ordenado
        if (inicio >= fin) {
            return true;
        }

        // Verificar si el elemento actual es mayor que el siguiente
        if (arr[inicio] > arr[inicio + 1]) {
            return false; // Si no está ordenado, retornamos falso
        }

        // Llamada recursiva con el siguiente par de elementos
        return Ordenado(arr, inicio + 1, fin);
    }

}
// 1) complejidad del algoritmo es o(N) => Depende del tam del arreglo de entrada
//2) si el arreglo es muy largo puede generar un desbordamiento de cola.
//3) deberia cambiar el inicio e final, e ir accediendo a los nodos atraves de sus metodos getNext()