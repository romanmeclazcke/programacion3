package ejercicio5;

public class main {

    public static void main(String[] args) {
        int [] arr={-2,1,2,6,7,8,9};
        System.out.println(Cumple(arr, 0));
    }


    public static boolean Cumple(int[]arr, int iteracciones){
        if (iteracciones>arr.length-1) {
            return false; 
        }else{ 
        if(arr[iteracciones]==iteracciones){
            return true;
        }else{
            return Cumple(arr, iteracciones+1);
        }
        }
    }
    
}
