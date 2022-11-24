package matriz_adyacencia;

public class MatrizAdyacencia<T> {
	
	public boolean esGrafoDirigido;
	
	public Vertice<T>[] vertices;
	
	public int[][] matrizConPesos;
	
	public Arista<T>[][] matrizAristas;
	
	@SuppressWarnings("unchecked")
	public MatrizAdyacencia(int numeroVertices) {
		this.esGrafoDirigido = false;
		this.vertices = new Vertice[numeroVertices];
		this.matrizConPesos = new int[numeroVertices][numeroVertices];
		this.matrizAristas = new Arista[numeroVertices][numeroVertices];
	}
	
	public void agregarVertice(T dato) {
		Vertice<T> nuevo = new Vertice<T>(dato);
		boolean agregado = false;
		
		for (int i = 0 ; i < vertices.length && !agregado ; i++) {
			if (vertices[i] == null) {
				nuevo.setIndice(i);
				vertices[i] = nuevo;
				agregado = true;
			}
		}
	}
	
	public Vertice<T> buscarVertice(T dato) {
		for (Vertice<T> buscado : vertices) {
			if (buscado.getDato().equals(dato))
				return buscado;
		}
		return null;
	}
	
	public void eliminarVertice(T dato) {
		Vertice<T> verticeEliminar = buscarVertice(dato);
		
		if (verticeEliminar != null) {
			int indice = verticeEliminar.getIndice();

			// Elimina las aristas adyacentes a este vertice.
			for (int i = 0 ; i < matrizAristas.length ; i++) {
				if (matrizAristas[i][indice] != null) {
					matrizAristas[i][indice] = null;
					matrizConPesos[i][indice] = 0;
				}
			}
			
			// Elimina las aristas que tienen como origen este vertice.
			for(int i = 0 ; i < matrizAristas[indice].length ; i++) {
				if ( matrizAristas[indice][i] != null ) {
					matrizAristas[indice][i] = null;
					matrizConPesos[indice][i] = 0;
				}
			}
		}
		
		boolean eliminado = false;
		for (int i = 0 ; i < vertices.length && !eliminado ; i++) {
			if (vertices[i].getDato().equals(dato)) {
				vertices[i] = null;
				eliminado = true;
			}
		}
	}

	public void agregarAristaMatriz(T datoVerticeOrigen, T datoVerticeDestino) {
		Vertice<T> origen = buscarVertice(datoVerticeOrigen);
		Vertice<T> destino = buscarVertice(datoVerticeDestino);
		
		if(origen != null && destino != null) {
			int fila = origen.getIndice();
			int columna = destino.getIndice();

			if (esGrafoDirigido) {
				Arista<T> arista = new Arista<>(origen, destino);
				matrizAristas[fila][columna] = arista;
			} else {
				Arista<T> a1 = new Arista<>(origen, destino);
				Arista<T> a2 = new Arista<>(destino, origen);
				matrizAristas[fila][columna] = a1;
				matrizAristas[columna][fila] = a2;
			}
		}
	}
	
	public void agregarAristaMatriz(T datoVerticeOrigen, T datoVerticeDestino, int peso) {
		Vertice<T> origen = buscarVertice(datoVerticeOrigen);
		Vertice<T> destino = buscarVertice(datoVerticeDestino);
		
		if(origen != null && destino != null) {
			int fila = origen.getIndice();
			int columna = destino.getIndice();

			if (esGrafoDirigido) {
				Arista<T> arista = new Arista<>(origen, destino, peso);
				matrizAristas[fila][columna] = arista;
				matrizConPesos[fila][columna] = arista.getPeso();
			} else {
				Arista<T> a1 = new Arista<>(origen, destino, peso);
				Arista<T> a2 = new Arista<>(destino, origen, peso);
				matrizAristas[fila][columna] = a1;
				matrizConPesos[fila][columna] = a1.getPeso();
				matrizAristas[columna][fila] = a2;
				matrizConPesos[columna][fila] = a2.getPeso();
			}
		}
	}
	
	public boolean comprobarExistenciaArista(T datoVerticeOrigen, T datoVerticeDestino) {
		Vertice<T> origen = buscarVertice(datoVerticeOrigen);
		Vertice<T> destino = buscarVertice(datoVerticeDestino);
		
		if (origen != null && destino != null) {
			int fila = origen.getIndice();
			int columna = destino.getIndice();
			
			if (matrizAristas[fila][columna] != null) {
				return true;
			}
		}
		return false;
	}
	
	public void eliminarAristaMatriz(T datoVerticeOrigen, T datoVerticeDestino) {
		Vertice<T> origen = buscarVertice(datoVerticeOrigen);
		Vertice<T> destino = buscarVertice(datoVerticeDestino);
		
		if (origen != null && destino != null) {
			int fila = origen.getIndice();
			int columna = destino.getIndice();
			
			if (esGrafoDirigido) {
				matrizAristas[fila][columna] = null;
			} else {
				matrizAristas[fila][columna] = null;
				matrizAristas[columna][fila] = null;
			}
		}
	}
	
}
