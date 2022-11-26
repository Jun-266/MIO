package model;

import grafo.ListaAdyacencia;
import grafo.MatrizAdyacencia;
import grafo.Vertice;

public class CentroOperacion {
	
	final int NUMERO_VERTICES = 60;

	private ListaAdyacencia<String> listaEstacionesDistancia;
	private MatrizAdyacencia<String> matrizEstacionesDistancia;
	
	public CentroOperacion() {
		this.listaEstacionesDistancia = new ListaAdyacencia<>(true);
		this.matrizEstacionesDistancia = new MatrizAdyacencia<>(NUMERO_VERTICES);
	}
	
	public ListaAdyacencia<String> getListaEstacionesDistancia() {
		return this.listaEstacionesDistancia;
	}
	
	public MatrizAdyacencia<String> getMatrizEstacionesDistancia() {
		return this.matrizEstacionesDistancia;
	}
	
	public void agregarEstacion(String nombreEstacion) {
		listaEstacionesDistancia.agregarVertice(nombreEstacion);
		matrizEstacionesDistancia.agregarVertice(nombreEstacion);
	}
	
	public boolean eliminarEstacionLED(String nombreEstacion) {
		return listaEstacionesDistancia.eliminarVertice(nombreEstacion);
	}
	
	public boolean eliminarEstacionMED(String nombreEstacion) {
		return matrizEstacionesDistancia.eliminarVertice(nombreEstacion);
	}
	
	public Vertice<String> buscarEstacionLED(String nombreEstacion) {
		return listaEstacionesDistancia.buscarVertice(nombreEstacion);
	}
	
	public Vertice<String> buscarEstacionMED(String nombreEstacion) {
		return matrizEstacionesDistancia.buscarVertice(nombreEstacion);
	}
	
	public boolean agregarRutaDistancia(String origen, String destino, int distancia) {
		boolean a, b;
		a = matrizEstacionesDistancia.agregarAristaMatriz(origen, destino, distancia);
		b = listaEstacionesDistancia.agregarArista(origen, destino, distancia);
		if ( a && b ) 
			return true;
		
		return false;
	}
	
	public boolean eliminarRutaDistancia(String origen, String destino) {
		boolean a, b;
		a = matrizEstacionesDistancia.eliminarAristaMatriz(origen, destino);
		b = listaEstacionesDistancia.eliminarArista(origen, destino);
		
		if (a && b)
			return true;

		return false;
	}
	
}
