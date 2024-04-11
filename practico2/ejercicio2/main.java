package ejercicio2;

public class main {

    public static void main(String[] args) {
        int[] arr = {2,5,8,9,10,12,13,17,20,22,88}; // Ejemplo de arreglo ordenado

        System.out.println(buscar(arr,0,22));
       

        
    }
    

    public  static  int buscar(int[] arr, int posicion, int elemento){
        if(elemento<arr[posicion]){ 
            return -1;
        }else{
            if(arr[posicion]==elemento){
                return posicion;
            }
            return buscar(arr, posicion+1, elemento);
        }
    }
}
