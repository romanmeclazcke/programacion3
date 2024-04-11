package ejercicio4;

public class main {
    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }
    public static int fibonacci(int numero){
        if(numero==0 || numero==1){
            return 1;
        }
    
        return fibonacci(numero-1)+ fibonacci(numero-2);
    }




    
}



