public class Main {

	public static void main(String[] args) {

		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
		
		// Agrego los vertices 1 y 2
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(4);
		grafito.agregarVertice(5);
		grafito.agregarVertice(6);
		grafito.agregarVertice(7);
		grafito.agregarVertice(8);
		grafito.agregarVertice(9);
		grafito.agregarVertice(10);
		grafito.agregarVertice(11);
		grafito.agregarVertice(12);

		// Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
		grafito.agregarArco(1, 2, null);
		grafito.agregarArco(1, 3, null);
		grafito.agregarArco(2, 3, null);
		grafito.agregarArco(3, 4, null);
		grafito.agregarArco(4, 5, null);
		grafito.agregarArco(4, 6, null);
		grafito.agregarArco(6, 7, null);
		grafito.agregarArco(7, 8, null);
		grafito.agregarArco(2, 9, null);
		grafito.agregarArco(9, 10, null);
		grafito.agregarArco(10, 8, null);
		grafito.agregarArco(11, 12, null);

		GetBranchLong getRamaMasLarga = new GetBranchLong();
		System.out.println(getRamaMasLarga.getBranchLong(grafito, 1, 8));
		

		// System.out.println(grafito.cantidadVertices());
		// System.out.println(grafito.cantidadArcos());
		// grafito.borrarArco(1,2);
		// System.err.println(grafito.contieneVertice(1));



	
	}

}
