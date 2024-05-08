import java.util.Iterator;
import java.util.LinkedList;


public class GrafoDirigido<T> implements Grafo<T> {
	private LinkedList<Vertice<T>> listaVertices;

	public GrafoDirigido() {
		this.listaVertices = new LinkedList<Vertice<T>>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		Vertice<T> v = new Vertice(verticeId);
		this.listaVertices.add(v);
	}

	@Override
	public void borrarVertice(int verticeId) {
		int index = this.getIndexVertice(verticeId);
		if (index != -1) {
			this.listaVertices.remove(index);

		}
	}

	public int getIndexVertice(int verticeId) {
		for (int i = 0; i < listaVertices.size(); i++) {
			if (listaVertices.get(i).getValue() == verticeId) {
				return i;
			}
		}
		return -1;
	}

	public Vertice<T> getVertice(int id) {
		for (int i = 0; i < listaVertices.size(); i++) {
			if (listaVertices.get(i).getValue() == id) {
				return listaVertices.get(i);
			}
		}
		return null;
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Vertice<T> v1 = this.getVertice(verticeId1);
		Vertice<T> v2 = this.getVertice(verticeId2);
		if (v1 != null && v2 != null) {
			Arco<T> arc = new Arco<T>(verticeId1, verticeId2, etiqueta);
			v1.addAdyacente(arc, v2); // agrego a la lista de arcos y a la de vertices
		}
		;
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Vertice<T> v1 = this.getVertice(verticeId1);
		Vertice<T> v2 = this.getVertice(verticeId2);
		if (v1 != null && v2 != null) {
			v1.deleteArco(verticeId2, v2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.listaVertices != null;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		Vertice<T> v1 = this.getVertice(verticeId1);
		Vertice<T> v2 = this.getVertice(verticeId2);
		if (v1 != null && v2 != null) {
			if (v1.ExistArco(verticeId2) != -1) {
				return true;

			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (this.getVertice(verticeId1) != null && this.getVertice(verticeId2) != null) {
			return this.getVertice(verticeId1).getArco(verticeId2);
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.listaVertices.size();
	}

	@Override
	public int cantidadArcos() {
		int suma = 0;
		for (Vertice<T> v : this.listaVertices) {
			suma += v.getCantArcos();
		}
		return suma;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		LinkedList<Integer> vertices = new LinkedList<>();
		for (Vertice<T> v : this.listaVertices) {
			vertices.add(v.getValue());
		}
		return vertices.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		LinkedList<Integer> vertices = new LinkedList<>();
		Vertice<T> vertice = this.getVertice(verticeId);
		if (vertice != null) {
			for (Arco<T> arco : vertice.getListaAdyacenciaArcos()) {
				vertices.add(arco.getVerticeDestino());
			}
		}
		return vertices.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		LinkedList<Arco<T>> aux = new LinkedList<Arco<T>>();
		for (Vertice<T> vertice : this.listaVertices) {
			aux.addAll(vertice.getListaAdyacenciaArcos());
		}
		return aux.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		LinkedList<Arco<T>> resultado = new LinkedList<>();
		this.getVertice(verticeId).getListaAdyacenciaArcos();
		for (Vertice<T> vertice : this.listaVertices) {
			resultado.addAll(vertice.getListaAdyacenciaArcos());
		}
		return resultado.iterator();

	}

	@Override
	public void DepthFirstSearch(int verticeId) {
		for (Vertice<T> vertice : this.listaVertices) {
			vertice.setColor("blanco");
		}

		for (Vertice<T> v : this.listaVertices) {
			if (v.getColor() == "blanco") {
				dfsVisit(v);
			}
		}
	}

	public void dfsVisit(Vertice<T> vertice) {
		vertice.setColor("Amarillo");
		// tiempo = tiempo+1;
		// vertice.setTiempoInicio = tiempo;

		for (Vertice<T> v : vertice.getListaAdyacenciaVertices()) {
			if (v.getColor() == "Blanco") {
				dfsVisit(v);
			}
		}

		vertice.setColor("Negro");
		// tiempo = tiempo+1
		// vertice.setTiempoFin= tiempo;
	}

	public boolean hasCycle() {
		for (Vertice<T> vertice : this.listaVertices) {
			return this.dfsVisitHasCycle(vertice);
		}
		return false;
	}

	public boolean dfsVisitHasCycle(Vertice<T> vertice) {// metodo encargado de recorrer en dfs y verificar si hay algun
														// vertice por visitar que este en amarillo
		vertice.setColor("Amarillo"); // si existe significa que estoy en un ciclo y deberia terminar de recorrer
		// tiempo = tiempo+1;
		// vertice.setTiempoInicio = tiempo;

		for (Vertice<T> v : vertice.getListaAdyacenciaVertices()) {
			if (v.getColor() == "Blanco") {
				// dfsVisit(v);
			}
			if (v.getColor() == "Amarillo") {
				return true;
			}
		}
		vertice.setColor("Negro");
		// tiempo = tiempo+1
		// vertice.setTiempoFin= tiempo;
		return false;
	}

	@Override
	public void BreadthFirstSearch() {

	}

}
