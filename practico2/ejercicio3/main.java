package ejercicio3;

public class main {
    public static void main(String[] args) {
        System.out.println(convertir(26));
    }

    public static String convertir(int numero) {
        if (numero == 0) {
            return "0";
        } else if (numero == 1) {
            return "1";
        }
        int residuo = numero % 2;
        int cociente = numero / 2;
        // Llamada recursiva para obtener la representación binaria del cociente y luego concatenar el residuo
        return   convertir(cociente) +residuo ;
    }
}
