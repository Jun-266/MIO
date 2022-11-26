package model;

public class Estacion {
	
	private String nombre;
	private int capacidadUsuarios;
	private String direccion;
	
	public Estacion(String nombre, int capacidadUsuarios, String direccion) {
		this.nombre = nombre;
		this.capacidadUsuarios = capacidadUsuarios;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCapacidadUsuarios() {
		return capacidadUsuarios;
	}

	public String getDireccion() {
		return direccion;
	}

}
