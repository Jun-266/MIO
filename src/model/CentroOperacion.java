package model;

import grafo.ListaAdyacencia;
import grafo.MatrizAdyacencia;
import grafo.Vertice;
import enums.Color;

public class CentroOperacion {
	
	final int NUMERO_VERTICES = 60;

	private ListaAdyacencia<String> listaEstacionesDistancia;
	private MatrizAdyacencia<String> matrizEstacionesDistancia;
	
	public CentroOperacion() {
		this.listaEstacionesDistancia = new ListaAdyacencia<>(false);
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
	
	public String agregarArista(String origen,String destino, int peso ) {
		boolean hecho = listaEstacionesDistancia.agregarArista(origen,destino,peso);
		matrizEstacionesDistancia.agregarAristaMatriz(origen,destino,peso);
		
		if(!hecho) {
			return "No existe alguna de las dos estaciones ingresadas";
		}
		return "Ha sido agregado";
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
		return matrizEstacionesDistancia.agregarAristaMatriz(origen, destino, distancia);
	}
	
	public String eliminarArista(String src, String dst) {
		boolean ok=listaEstacionesDistancia.eliminarArista(src, dst);
		matrizEstacionesDistancia.eliminarAristaMatriz(src, dst);
		if(ok) 
			return "Se ha eliminado la arista";
		else
			return "Verifica las estaciones que has ingresado";
					
	}
	public String calcularRutaMenor(String origen, String destino) {
		String msg="";
		Vertice<String> src=buscarEstacionLED(origen);
		Vertice<String> dst=buscarEstacionLED(destino);
		
		if(dst!=null && src!=null) {
			listaEstacionesDistancia.recorridoBFS(src);
			if(dst.getColor().equals(Color.BLANCO))
				return "No se puede acceder a esta estación desde este punto de origen";
			
			listaEstacionesDistancia.dijkstra(src);
		}
			
		else
			return "No existe una estación de origen con el nombre dado y/o una estación de destino con este nombre";
		
		while(dst!=null) {
			if(dst.getPadre()!=null)
				msg+=dst.getDato()+" <== ";
			else
				msg+=dst.getDato();
			
			dst=dst.getPadre();
		}
		
		return msg;
		
	}
	
	public String esAccesible(String origen, String destino) {
		Vertice<String> src=buscarEstacionLED(origen);
		Vertice<String> dst=buscarEstacionLED(destino);
		
		if(dst!=null && src!=null)
			src=listaEstacionesDistancia.dijkstra(src);
		else
			return "No existe una estación de origen con el nombre dado y/o una esteción de destino con este nombre";
		
		listaEstacionesDistancia.recorridoBFS(src);
		
		if(dst.getColor().equals(Color.BLANCO))
			return "No se puede acceder a esta estación desde este punto de origen";
		else
			return "Si hay acceso desde este punto de origen al destino";
					
	}

}
