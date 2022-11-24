package ui;

import matriz_adyacencia.Arista;
import matriz_adyacencia.MatrizAdyacencia;

public class Menu {
	
	public void iniciar() {
		
	}
	
	public static void main(String[] args) {
		MatrizAdyacencia<String> grafo = new MatrizAdyacencia<>(5);
		// grafo.esGrafoDirigido = true;
		grafo.agregarVertice("A");
		grafo.agregarVertice("B");
		grafo.agregarVertice("C");
		grafo.agregarVertice("D");
		grafo.agregarVertice("E");
		
		grafo.agregarAristaMatriz("A", "D");
		grafo.agregarAristaMatriz("A", "B");
		grafo.agregarAristaMatriz("A", "C");
		grafo.agregarAristaMatriz("B", "C");
		grafo.agregarAristaMatriz("C", "E");
		grafo.agregarAristaMatriz("E", "A");
		
		Arista<String>[][] ma = grafo.matrizAristas;
		
		for (int i = 0 ; i < ma.length ; i++) {
			for (int j = 0 ; j < ma[i].length ; j++) {
				if ( ma[i][j] != null ) {
					System.out.print("[" + 1 + "]");
				} else {
					System.out.print("[" + "*" + "]");
				}
			}
			System.out.println();
		}
		
		grafo.eliminarVertice("B");
		System.out.println();
		
		for (int i = 0 ; i < ma.length ; i++) {
			for (int j = 0 ; j < ma[i].length ; j++) {
				if ( ma[i][j] != null ) {
					System.out.print("[" + 1 + "]");
				} else {
					System.out.print("[" + "*" + "]");
				}
			}
			System.out.println();
		}
	}

}
