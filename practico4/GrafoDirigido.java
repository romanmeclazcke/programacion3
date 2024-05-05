import java.util.Iterator;
import java.util.LinkedList;
public class GrafoDirigido<T> implements Grafo<T> {
	private LinkedList<Vertice> listaVertices;

	public GrafoDirigido(){
		this.listaVertices= new LinkedList<Vertice>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		Vertice v = new Vertice(verticeId);
		this.listaVertices.add(v);
	}

	@Override
	public void borrarVertice(int verticeId) {
		for(int i=0;i<listaVertices.size();i++){
			if(listaVertices.get(i).getValue()==verticeId){
				listaVertices.remove(i);
			}
		}
	}


	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(this.getVertice(verticeId1)!=null && this.getVertice(verticeId2)!=null){
			Arco<T> arc= new Arco<T>(verticeId1, verticeId2, etiqueta);
			this.getVertice(verticeId1).addAdyacente(this.getVertice(verticeId2));
		};
	}

	public Vertice getVertice(int id){
		for(int i=0;i<listaVertices.size();i++){
			if (listaVertices.get(i).getValue()==id) {
				return listaVertices.get(i);
			}
		}
		return null;
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (this.getVertice(verticeId1)!=null && this.getVertice(verticeId2)!=null) {
			this.getVertice(verticeId1).deleteArco(verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.listaVertices!=null;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		Vertice v1 = this.getVertice(verticeId1);
		Vertice v2 = this.getVertice(verticeId2);
		if (v1!=null) {
			LinkedList<Vertice> aux = v1.getList();
			return aux.contains(v2);
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// hacer
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.listaVertices.size();
	}

	@Override
	public int cantidadArcos() {
		int suma=0;
		for (Vertice v : listaVertices) {
			suma +=v.getCantArcos();
		}
		return suma;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DepthFirstSearch(int verticeId) {
		for (Vertice vertice : this.listaVertices) {
			vertice.setColor("blanco");
		}


		for (Vertice v : this.listaVertices) {
			if (v.getColor()=="blanco") {
				dfsVisit(v);
			}
		}
	}

	public void dfsVisit(Vertice vertice){
		vertice.setColor("Amarillo");
		//tiempo = tiempo+1;
		//vertice.setTiempoInicio = tiempo;

		for (Vertice v : vertice.getList()) {
			if (v.getColor()=="Blanco") {
				dfsVisit(v);
			}
		}

		//vertice.setColor="Negro"
		//tiempo = tiempo+1
		//vertice.setTiempoFin= tiempo;
	}

	@Override
	public void BreadthFirstSearch() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'BreadthFirstSearch'");
	}

}
