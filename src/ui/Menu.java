package ui;

import grafo.ListaAdyacencia;
import grafo.Vertice;

public class Menu {
	
	public void iniciar() {
		
	}
	
	public static void main(String[] args) {
		ListaAdyacencia<String> la = new ListaAdyacencia<>(false);

		Vertice<String> at = la.agregarVertice("At");
		Vertice<String> ch = la.agregarVertice("Ch");
		Vertice<String> de = la.agregarVertice("De");
		Vertice<String> ny = la.agregarVertice("NY");
		Vertice<String> sf = la.agregarVertice("SF");
		
		at.agregarArista(ch, 700);
		at.agregarArista(de, 1400);
		at.agregarArista(ny, 800);
		at.agregarArista(sf, 2200);
		
		ch.agregarArista(at, 700);
		ch.agregarArista(de, 1300);
		ch.agregarArista(ny, 1000);
		ch.agregarArista(sf, 1200);
		
		de.agregarArista(at, 1400);
		de.agregarArista(ch, 1300);
		de.agregarArista(ny, 1600);
		de.agregarArista(sf, 900);
		
		ny.agregarArista(at, 800);
		ny.agregarArista(ch, 1000);
		ny.agregarArista(de, 1600);
		ny.agregarArista(sf, 2000);
		
		sf.agregarArista(at, 2200);
		sf.agregarArista(ch, 1200);
		sf.agregarArista(de, 900);
		sf.agregarArista(ny, 2000);
		
		la.algoritmoDePrim(at);
	}
	
}
