public class main {

    public static void main(String[] args) {
        int[] arreglo = { 10000,1, 3, 5, 6, 7, 9, 203, 301, 22, 3, 4,0 };
        int[] arregloOrdenado = ordenamientoBurbujeo(arreglo);
        for (int i : arregloOrdenado) {
            System.out.println(i);
        }
    }

    // A)
    // ordenamiento por seleccion
    // selecciono uno y voy avanzando hasta encontrar uno menor, cambio los
    // elementos
    // complejidad o(n2) =>peor de los casos, recorro el arreglo entero 2 veces
    public static int[] ordenamientoSeleccion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[indiceMenor];
            arr[indiceMenor] = temp;
        }
        return arr;
    }

    // B)
    // ordenamiento por burbujeo

    public static int[] ordenamientoBurbujeo(int []arr){
        int i,j,aux;
        for(i=0;i<arr.length-1;i++){
            for(j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    aux = arr[ j+1 ];
                    arr[ j+1 ] = arr[ j ];
                    arr[ j ] = aux;

                }
            }
        }
        return arr;
    }

    
}
