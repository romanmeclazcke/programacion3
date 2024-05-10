import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;



public class GrafoDirigido<T> implements Grafo<T> {
	

	private Hashtable<Integer,LinkedList<Arco<T>>> vertices;

	public GrafoDirigido() {
		this.vertices= new Hashtable<>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		this.vertices.put(verticeId, new LinkedList<Arco<T>>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		if (this.vertices.containsKey(verticeId)) {
			this.vertices.remove(verticeId);	

			Iterator<Integer> it = this.vertices.keySet().iterator();

			while (it.hasNext()) {
				LinkedList<Arco<T>> lista = this.vertices.get(it.next());
				Iterator<Arco<T>> iteradorLista= lista.iterator();

				while(iteradorLista.hasNext()){
					Arco<T> arco = iteradorLista.next();
					if(arco.getVerticeDestino()==verticeId){
						lista.remove(arco);
					}
				}
			}
			
			
		}


	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (this.vertices.containsKey(verticeId1) && this.vertices.containsKey(verticeId2)) {
			Arco<T> arco= new Arco<T>(verticeId1, verticeId2, etiqueta);
			this.vertices.get(verticeId1).add(arco);
			
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (this.vertices.containsKey(verticeId1)&&this.vertices.containsKey(verticeId2)) {
			this.vertices.get(verticeId1).remove(verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		if (this.vertices.containsKey(verticeId)) {
			return this.vertices.get(verticeId)!=null;
		}
		return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (this.vertices.containsKey(verticeId1) && this.vertices.containsKey(verticeId2)) {
			Iterator<Arco<T>> iterator = this.vertices.get(verticeId1).iterator();

			while(iterator.hasNext()){
				Arco<T> aux = iterator.next();
				if (aux.getVerticeOrigen()== verticeId1 && aux.getVerticeDestino()==verticeId2) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (this.vertices.containsKey(verticeId1) && this.vertices.containsKey(verticeId2)) {
			Iterator<Arco<T>> iterator = this.vertices.get(verticeId1).iterator();
			//get retorna linkedlist de arco (el valor asociado a la clave) => iterator agarro el iterador de esa lista de arcos

			while(iterator.hasNext()){
				Arco<T> aux = iterator.next();
				if (aux.getVerticeOrigen()== verticeId1 && aux.getVerticeDestino()==verticeId2) {
					return aux;
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int contador=0;
		for (LinkedList<Arco<T>> lista : vertices.values()) {
			contador += lista.size();
		}
		return contador;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return this.vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		LinkedList<Arco<T>> aux= new LinkedList<>();
		for(Integer vertice : this.vertices.keySet()){
			aux.addAll(this.vertices.get(vertice));
		}
		return aux.iterator();
	}



	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
			if (this.vertices.containsKey(verticeId)) {
				return this.vertices.get(verticeId).iterator();
			}
			return null;
	
	}

	@Override
	public void DepthFirstSearch(int verticeId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'DepthFirstSearch'");
	}

	@Override
	public void BreadthFirstSearch() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'BreadthFirstSearch'");
	}

	


}
