package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.CentroOperacion;

public class Programa {

	private CentroOperacion sistemaMIO;

	public Programa() {
		this.sistemaMIO = new CentroOperacion();
	}

	public CentroOperacion getSistemaMIO() {
		return sistemaMIO;
	}

	public void menu() {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		boolean terminado = false;
		while (!terminado) {
			try {
				System.out.println("Sistema de gestión de rutas y estaciones del MIO.");
				System.out.println("Digita el número de la opción a ejecutar.");
				System.out.println("1) Agregar una estación.");
				System.out.println("2) Eliminar una estación.");
				System.out.println("3) Buscar una estación.");
				System.out.println("4) Agregar una ruta con tiempo especifico.");
				System.out.println("5) Agregar una ruta con una distancia especifica.");
				System.out.println("6) Eliminar una ruta que contiene distancia.");
				System.out.println("7) Eliminar una ruta que contiene tiempo.");
				System.out.println("8) Salir");

				String input = lector.readLine();
				int opcion = Integer.parseInt(input);

				switch (opcion) {
				case 1:
					opcion1();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					terminado = true;
					System.out.println("¡Hasta la proxima!");
					lector.close();
					break;
				default:
					System.out.println("Digita una opción valida.");
					System.out.println();
				}
			} catch (IOException e) {

			} catch (NumberFormatException e) {
				System.out.println("No se permiten caracteres para las opciones disponibles.");
				System.out.println();
			}
		}
	}
	
	public void opcion1() {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Escribe el nombre de la estación: ");
		try {
			String nombreEstacion = lector.readLine();
			sistemaMIO.agregarEstacion(nombreEstacion);
			System.out.println();
			System.out.println("¡La estación fue agregada de manera exitosa!");
			System.out.println();
		} catch (IOException e) {
			System.out.println("Error en el flujo de entrada de datos.");
		}
	}
	
	public void opcion2() {
		
	}
	
	public void opcion3() {
		
	}
	
	public void opcion4() {
		
	}
	
	public void opcion5() {
		
	}

	public static void main(String[] args) {
		Programa p = new Programa();
		p.menu();
	}

}
