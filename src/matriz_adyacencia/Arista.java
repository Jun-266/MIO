package matriz_adyacencia;

public class Arista<T> {
	
	private Vertice<T> origen;
	private Vertice<T> destino;
	
	private int peso;
	
	public Arista(Vertice<T> origen, Vertice<T> destino) {
		this.origen = origen;
		this.destino = destino;
	}
	
	public Arista(Vertice<T> origen, Vertice<T> destino, int peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
	}

	public Vertice<T> getOrigen() {
		return origen;
	}

	public void setOrigen(Vertice<T> origen) {
		this.origen = origen;
	}

	public Vertice<T> getDestino() {
		return destino;
	}

	public void setDestino(Vertice<T> destino) {
		this.destino = destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}
